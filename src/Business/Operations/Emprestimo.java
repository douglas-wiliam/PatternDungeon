package Business.Operations;

import Business.Library.Exemplar;
import Business.Users.Usuario;

/**
 *
 * @author douglas
 */
public class Emprestimo {

    Usuario usuario;
    Exemplar exemplar;
    String dataCriacao;
    String dataDevolucao;
    String status;

    public Emprestimo(Usuario usuario, Exemplar exemplar) {
        this.usuario = usuario;
        this.exemplar = exemplar;
        dataCriacao = "";
        dataDevolucao = "";
        status = "emcurso";  // "emcurso" ou "finalizado"
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Exemplar getLivro() {
        return exemplar;
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
