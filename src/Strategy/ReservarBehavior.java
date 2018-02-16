package Strategy;

import Business.Library.Livro;
import Business.Users.Usuario;

/**
 *
 * @author douglas
 */
public interface ReservarBehavior {

    public String reservar(Usuario usuario, Livro livro);
}
