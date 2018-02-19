package Command;
import Facade.Fachada;

/**
 *
 * @author guilherme
 */
public class RealizaConsultaUsuarioComando implements Comando {
    private final String codigoUsuario;
    
    public RealizaConsultaUsuarioComando (String codigoUsuario){
        this.codigoUsuario = codigoUsuario;
    }
    
    @Override
    public String execute(){
        return Fachada.realizaConsultaUsuario(codigoUsuario);
    }
    
    
}
