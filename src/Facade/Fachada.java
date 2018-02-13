package Facade;

import Business.Library.Biblioteca;
import Business.Library.Livro;
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
        Usuario usuario = Biblioteca.buscaUsuario(pedidoEmprestimo.getCodigoUsuario());
        Livro livro = Biblioteca.buscaLivro(pedidoEmprestimo.getCodigoLivro());
        Emprestimo emprestimo;

        if (usuario == null) {
            return "Usuário não existe na Biblioteca";
        }

        if (livro == null) {
            return "Livro não existe na Biblioteca";
        }

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
        return "Empréstimo realizado com sucesso";
    }
}
