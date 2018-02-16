package Business.Operations;

import Business.Library.Exemplar;
import Business.Users.Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author douglas
 */
public class Emprestimo {

    Usuario usuario;
    Exemplar exemplar;
    String dataCriacao;
    String dataDevolucao;
    String status;  // "emCurso" ou "finalizado"

    public Emprestimo(Usuario usuario, Exemplar exemplar) {
        this.usuario = usuario;
        this.exemplar = exemplar;
    }

    private void registraData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataLocal = LocalDate.now();

        dataCriacao = dtf.format(dataLocal);
        dataDevolucao = dtf.format(dataLocal.plusDays(usuario.getPeriodoEmprestimo()));
    }

    private void atualizaDataDevolucao() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataLocal = LocalDate.now();

        dataDevolucao = dtf.format(dataLocal);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Exemplar getExemplar() {
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

    public void setStatus(String status) {
        if (status.equals("finalizado")) {
            exemplar.setStatus("disponivel");
            exemplar.setEmprestimo(null);
            atualizaDataDevolucao();
        } else {
            registraData();
            exemplar.setStatus("emprestado");
            exemplar.setEmprestimo(this);
        }
        this.status = status;
    }

}
