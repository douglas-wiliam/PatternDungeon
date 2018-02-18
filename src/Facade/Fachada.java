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

    public static String realizaEmprestimo(Pedido pedido) {
        Usuario usuario = Biblioteca.buscaUsuario(pedido.getCodigoUsuario());
        Livro livro = Biblioteca.buscaLivro(pedido.getCodigoLivro());

        if (usuario == null) {
            return "Usuário não existe na Biblioteca";
        }

        if (livro == null) {
            return "Livro não existe na Biblioteca";
        }

        return usuario.tomaEmprestado(livro);
    }

    public static String realizaDevolucao(Pedido pedido) {
        Usuario usuario = Biblioteca.buscaUsuario(pedido.getCodigoUsuario());
        Livro livro = Biblioteca.buscaLivro(pedido.getCodigoLivro());

        if (usuario == null) {
            return "Usuário não existe na Biblioteca";
        }

        if (livro == null) {
            return "Livro não existe na Biblioteca";
        }

        return usuario.devolve(livro);

    }

    public static String realizaReserva(Pedido pedido) {
        Usuario usuario = Biblioteca.buscaUsuario(pedido.getCodigoUsuario());
        Livro livro = Biblioteca.buscaLivro(pedido.getCodigoLivro());

        if (usuario == null) {
            return "Usuário não existe na Biblioteca";
        }

        if (livro == null) {
            return "Livro não existe na Biblioteca";
        }

        return usuario.reserva(livro);

    }
    
    public static String realizaConsultaUsuario(String codigoUsuario){
        Usuario usuario = Biblioteca.buscaUsuario(codigoUsuario);
        if (usuario == null) {
            return "Usuário não existe na Biblioteca";
        }
        return usuario.consulta();
    }
    
    public static String realizaCadastroObservador(Pedido pedido){
        Usuario usuario = Biblioteca.buscaUsuario(pedido.getCodigoUsuario());
        Livro livro = Biblioteca.buscaLivro(pedido.getCodigoLivro());

        if (usuario == null) {
            return "Usuário não existe na Biblioteca";
        }

        if (livro == null) {
            return "Livro não existe na Biblioteca";
        }
        
        return livro.addObservador(usuario);
        
    }
    
    public static String realizaCheckNotificacoes(String codigoUsuario){
        Usuario usuario = Biblioteca.buscaUsuario(codigoUsuario);
        if (usuario == null) {
            return "Usuário não existe na Biblioteca";
        }
        
        return usuario.getNotificacoes();
    }
}
