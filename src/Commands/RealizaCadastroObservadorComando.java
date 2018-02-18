
package Commands;

import Business.Orders.Pedido;

/**
 *
 * @author guilherme
 */
public class RealizaCadastroObservadorComando implements Comando {
     private final Pedido pedido;
     
     public RealizaCadastroObservadorComando(Pedido pedido){
         this.pedido = pedido;
     }
     
     @Override
     public String execute(){
         return Fachada.realizaCadastroObservador(pedido);
     }
    
    
}
