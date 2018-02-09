package Commands;

import Facade.Fachada;
import Business.Operations.PedidoEmprestimo;

/**
 *
 * @author douglas
 */
public class RealizaEmprestimoComando implements Comando {

    private PedidoEmprestimo pedidoEmprestimo;

    public RealizaEmprestimoComando(PedidoEmprestimo pedidoEmprestimo) {
        this.pedidoEmprestimo = pedidoEmprestimo;
    }

    @Override
    public String execute() {
        return Fachada.realizaEmprestimo(pedidoEmprestimo);
    }

}
