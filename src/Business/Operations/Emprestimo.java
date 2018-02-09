package Business.Operations;

/**
 *
 * @author douglas
 */
public class Emprestimo {

    String codigoUsuario;
    String codigoLivro;
    String dataCriacao;
    String dataDevolucao;

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

    public String getdataCriacao() {
        return dataCriacao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

}
