package Observer;

import Business.Users.Usuario;

/**
 *
 * @author guilherme
 */
public interface Sujeito {
    public void atualizaObservadores();
    public String addObservador(Usuario usuario);
    public String removeObservador(Usuario usuario);
}


