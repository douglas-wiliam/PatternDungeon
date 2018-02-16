package Commands;

import Business.Orders.Pedido;
import Facade.Fachada;

/**
 *
 * @author douglas
 */
public class RealizaEmprestimoComando implements Comando {

    private final Pedido pedido;

    public RealizaEmprestimoComando(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String execute() {
        return Fachada.realizaEmprestimo(pedido);
    }

}
