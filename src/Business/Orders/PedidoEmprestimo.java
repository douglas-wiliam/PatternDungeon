package Business.Orders;

/**
 *
 * @author douglas
 */
public class PedidoEmprestimo implements Pedido{

    String codigoUsuario;
    String codigoLivro;

    public PedidoEmprestimo(String codigoUsuario, String codigoLivro) {
        this.codigoUsuario = codigoUsuario;
        this.codigoLivro = codigoLivro;
    }

    @Override
    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    @Override
    public String getCodigoLivro() {
        return codigoLivro;
    }

}
