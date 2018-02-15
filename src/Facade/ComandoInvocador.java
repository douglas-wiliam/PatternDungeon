package Facade;

import Commands.Comando;

/**
 *
 * @author douglas
 */
public class ComandoInvocador {

    public ComandoInvocador() {
    }

    public String executeCommand(Comando comando) {
        return comando.execute();
    }

}
