package Business.Operations;

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

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public String getCodigoLivro() {
        return codigoLivro;
    }

}
