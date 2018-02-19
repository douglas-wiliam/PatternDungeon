package Command;

import Business.Orders.Pedido;
import Facade.Fachada;

/**
 *
 * @author douglas
 */
public class RealizaReservaComando implements Comando {

    private final Pedido pedido;

    public RealizaReservaComando(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String execute() {
        return Fachada.realizaReserva(pedido);
    }

}
