package Business;

import Business.Operations.Emprestimo;
import Business.Users.Usuario;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Biblioteca {

    private static Biblioteca uniqueInstance;
    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Emprestimo> emprestimos;

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

    public static void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public static void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

}
