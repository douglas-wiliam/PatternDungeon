package Business.Orders;

/**
 *
 * @author douglas
 */
public class Pedido {

    String codigoUsuario;
    String codigoLivro;

    public Pedido(String codigoUsuario, String codigoLivro) {
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
