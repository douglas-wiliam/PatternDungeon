package Commands;

import Facade.Fachada;

/**
 *
 * @author guilherme
 */
public class RealizaCheckNotificacoesComando implements Comando{
    private final String codigoUsuario;
    
    public RealizaCheckNotificacoesComando(String codigoUsuario){
        this.codigoUsuario = codigoUsuario;
    }
    
    public String execute(){
        return Fachada.realizaCheckNotificacoes(codigoUsuario);
    }
    
}
