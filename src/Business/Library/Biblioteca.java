package Business.Library;

import Business.Users.Usuario;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Biblioteca {

    private static Biblioteca uniqueInstance;
    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Livro> livros;

    private Biblioteca() {

    }

    public static synchronized Biblioteca getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Biblioteca();
        }

        return uniqueInstance;
    }

    public static Usuario buscaUsuario(String codigoUsuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static Livro buscaLivro(String codigoLivro) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static void addLivro(Livro livro) {
        livros.add(livro);
    }

    public static void removeUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public static void removeLivro(Livro livro) {
        livros.remove(livro);
    }

    public static ArrayList getUsuarios() {
        return usuarios;
    }

    public static ArrayList getLivros() {
        return livros;
    }

}
