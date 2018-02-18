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
    Usuario usuario;
    Livro livro;
    String dataSolicitacao;
    
    public Reserva(Usuario usuario, Livro livro){
        this.registraData();
        this.usuario = usuario;
        this.livro = livro;
    }
    
    private void registraData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataLocal = LocalDate.now();
        dataSolicitacao = dtf.format(dataLocal);
    }
    
    public Usuario getUsuario(){
        return this.usuario;
    }
    
    public Livro getLivro(){
        return this.livro;
    }
    
    public String getTituloLivro(){
        return this.livro.getTitulo();
    }
    
    public String getDataSolicitacao(){
        return this.dataSolicitacao;
    }
}
