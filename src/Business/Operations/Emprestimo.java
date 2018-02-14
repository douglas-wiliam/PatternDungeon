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
    String status;

    public Emprestimo(Usuario usuario, Exemplar exemplar) {
        this.usuario = usuario;
        this.exemplar = exemplar;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataLocal = LocalDate.now();
        
        dataCriacao = dtf.format(dataLocal);
        dataDevolucao = dtf.format(dataLocal.plusDays(usuario.getPeriodoEmprestimo()));
        status = "emCurso";  // "emCurso" ou "finalizado"
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
        this.status = status;
    }

}
