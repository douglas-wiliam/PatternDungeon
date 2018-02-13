package Commands;

import Business.Orders.Pedido;
import Facade.Fachada;

/**
 *
 * @author douglas
 */
public class RealizaEmprestimoComando implements Comando {

    private final Pedido pedidoEmprestimo;

    public RealizaEmprestimoComando(Pedido pedidoEmprestimo) {
        this.pedidoEmprestimo = pedidoEmprestimo;
    }

    @Override
    public String execute() {
        return Fachada.realizaEmprestimo(pedidoEmprestimo);
    }

}
