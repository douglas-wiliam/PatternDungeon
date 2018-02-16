package Strategy;

import Business.Library.Livro;
import Business.Users.Usuario;

/**
 *
 * @author douglas
 */
public interface TomarEmprestadoBehavior {

    public String tomarEmprestado(Usuario usuario, Livro livro);
}
