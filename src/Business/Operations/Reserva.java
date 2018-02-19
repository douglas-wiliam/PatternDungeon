package Business.Operations;

import Business.Library.Livro;
import Business.Users.Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author douglas, Guilherme
 */
public class Reserva {
    
    protected final Usuario usuario;
    protected final Livro livro;
    private String dataSolicitacao;
    
    public Reserva(Usuario usuario, Livro livro){
        this.registraData();
        this.usuario = usuario;
        this.livro = livro;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }
    
    private void registraData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataLocal = LocalDate.now();
        dataSolicitacao = dtf.format(dataLocal);
    }
        
    public String getTituloLivro(){
        return this.livro.getTitulo();
    }
    
    public String getDataSolicitacao(){
        return this.dataSolicitacao;
    }
}
