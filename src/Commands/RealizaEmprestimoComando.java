package Commands;

import Business.Operations.Pedido;
import Facade.Fachada;

/**
 *
 * @author douglas
 */
public class RealizaEmprestimoComando implements Comando {

    private Pedido pedidoEmprestimo;

    public RealizaEmprestimoComando(Pedido pedidoEmprestimo) {
        this.pedidoEmprestimo = pedidoEmprestimo;
    }

    @Override
    public String execute() {
        return Fachada.realizaEmprestimo(pedidoEmprestimo);
    }

}
