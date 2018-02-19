package Command;

import Business.Orders.Pedido;
import Facade.Fachada;

/**
 *
 * @author douglas
 */
public class RealizaDevolucaoComando implements Comando {

    private final Pedido pedido;

    public RealizaDevolucaoComando(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String execute() {
        return Fachada.realizaDevolucao(pedido);
    }

}
