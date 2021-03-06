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

    private final Usuario usuario;
    private final Exemplar exemplar;
    private String dataCriacao;
    private String dataDevolucao;
    private String status;  // "emCurso" ou "finalizado"

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

    public void abreEmprestimo() {
        registraData();
        status = "emCurso";
        exemplar.empresta(this);
    }

    public void fechaEmprestimo() {
        atualizaDataDevolucao();
        status = "finalizado";
        exemplar.devolve();
    }

    public boolean estaAberto() {
        return status.equals("emCurso");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getCodigoExemplar() {
        return exemplar.getCodigo();
    }

    public String getTituloExemplar() {
        return exemplar.getTitulo();
    }

    public String getCodigoLivro() {
        return exemplar.getCodigoLivro();
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
    
    @Override
    public String toString() {
        return "Emprestado para " + 
                this.getUsuario().getNome() + " em " +
                this.getDataCriacao() + " com devolução prevista para " + 
                this.getDataDevolucao();
    }
}
