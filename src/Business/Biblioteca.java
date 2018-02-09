package Business;

import Business.Users.Usuario;

/**
 *
 * @author douglas
 */
public class Biblioteca {

    private static Biblioteca uniqueInstance;

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

}
