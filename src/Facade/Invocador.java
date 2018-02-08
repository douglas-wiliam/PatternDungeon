package Facade;

import java.util.HashMap;
import java.util.Map;
import Command.Comando;

/**
 *
 * @author douglas
 */
public class Invocador {

    private Map mapCommands;

    public Invocador() {
        mapCommands = new HashMap();
    }

    public String executeCommand(Comando comando) {
        return comando.execute();
    }

    public void addCommand(Comando comando, String codigo) {
        mapCommands.put(codigo, comando);
    }

    public void removeCommand(String codigo) {
        mapCommands.remove(codigo);
    }

    public Map getMapCommands() {
        return mapCommands;
    }

}
