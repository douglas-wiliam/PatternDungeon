package Business;

/**
 *
 * @author douglas
 */
public class Emprestimo {

    String codigoUsuario;
    String codigoLivro;

    public Emprestimo(String codigoUsuario, String codigoLivro) {
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
