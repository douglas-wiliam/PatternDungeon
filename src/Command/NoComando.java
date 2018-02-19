package Command;

/**
 *
 * @author douglas
 */
public class NoComando implements Comando {

    @Override
    public String execute() {
        return "Nenhum Comando Registrado.";
    }

}
