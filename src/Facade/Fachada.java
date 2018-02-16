package Facade;

import Business.Library.Biblioteca;
import Business.Library.Livro;
import Business.Orders.Pedido;
import Business.Users.Usuario;

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

        if (usuario == null) {
            return "Usuário não existe na Biblioteca";
        }

        if (livro == null) {
            return "Livro não existe na Biblioteca";
        }

        return usuario.tomarEmprestado(livro);
    }
}
