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
    String status;

    public Emprestimo(String codigoUsuario, String codigoLivro) {
        this.codigoUsuario = codigoUsuario;
        this.codigoLivro = codigoLivro;
        status = "aberto";
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

    public String getStatus() {
        return status;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
