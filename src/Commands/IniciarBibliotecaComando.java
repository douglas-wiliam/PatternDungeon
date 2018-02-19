package Commands;

import Facade.Fachada;

/**
 *
 * @author douglas
 */
public class IniciarBibliotecaComando implements Comando {

    @Override
    public String execute() {
        return Fachada.iniciarBiblioteca();
    }
}