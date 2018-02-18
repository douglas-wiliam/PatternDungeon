package Business.Operations;

import Business.Library.Exemplar;
import Business.Users.Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author douglas, Guilherme
 */
public class Reserva {
    Usuario usuario;
    Exemplar exemplar;
    String dataSolicitacao;
    
    public Reserva(Usuario usuario, Exemplar exemplar){
        this.registraData();
        this.usuario = usuario;
        this.exemplar = exemplar;
    }
    
    private void registraData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataLocal = LocalDate.now();
        dataSolicitacao = dtf.format(dataLocal);
    }
    
    public Usuario getUsuario(){
        return this.usuario;
    }
    
    public Exemplar getExemplar(){
        return this.exemplar;
    }
    
    public String getDataSolicitacao(){
        return this.dataSolicitacao;
    }
}
