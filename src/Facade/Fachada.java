package Facade;

import Business.Biblioteca;
import Business.Livro;
import Business.Operations.Emprestimo;
import Business.Orders.Pedido;
import Business.Users.Usuario;
import Validate.Checker;

/**
 *
 * @author douglas
 */
public class Fachada {

    private static Fachada uniqueInstance;

    private Fachada() {
    }

    public static synchronized Fachada getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Fachada();
        }
        return uniqueInstance;
    }

    public static String realizaEmprestimo(Pedido pedidoEmprestimo) {
        // Supondo que os usuarios sejam validos
        Usuario usuario = Biblioteca.buscaUsuario(pedidoEmprestimo.getCodigoUsuario());
        Livro livro = Biblioteca.buscaLivro(pedidoEmprestimo.getCodigoLivro());
        Emprestimo emprestimo;
        
        usuario.setPedido(pedidoEmprestimo);

        for (Checker c : usuario.getCheckers()) {
            c.check();
            if (!"".equals(c.getLog())) {
                usuario.setPedido(null);
                return c.getLog();
            }
        }

        usuario.setPedido(null);
        emprestimo = new Emprestimo(pedidoEmprestimo.getCodigoUsuario(), pedidoEmprestimo.getCodigoLivro());
        usuario.addEmprestimo(emprestimo);
        livro.addEmprestimo(emprestimo);
        return "Empréstimo realizado com sucesso";
    }
}
