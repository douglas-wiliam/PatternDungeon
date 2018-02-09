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

    public String getDataCriacao() {
        return dataCriacao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

}
