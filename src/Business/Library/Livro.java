package Business.Library;

import Business.Operations.Emprestimo;
import Business.Operations.Reserva;
import Business.Users.Usuario;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Livro {

    private final String codigo;
    private final String titulo;
    private final String editora;
    private final String autores;
    private final String edicao;
    private final String anoPublicacao;
    private ArrayList<Exemplar> exemplares;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Reserva> reservas;
    private ArrayList<Usuario> observadores;

    public Livro(String codigo, 
                 String titulo, 
                 String editora, 
                 String autores,
                 String edicao,
                 String anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
    }

    public void addExemplar(String codigo) {
        exemplares.add(new Exemplar(this, codigo));
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
        if (reservas.size() == 2){
            for (Usuario obs : observadores){
                obs.notifica();
            }
        }
    }
    
    public String addObservador(Usuario usuario){
        observadores.add(usuario);
        return "Observador Adicionado";
    }

    public void removeExemplar(String codigo) {
        for (Exemplar e : exemplares) {
            if (codigo.equals(e.getCodigo())) {
                exemplares.remove(e);
            }
        }
    }

    public String getCodigo() {
        return codigo;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public String getEditora(){
        return this.editora;
    }
    
    public String getAutores(){
        return this.autores;
    }
    
    public String getEdicao(){
        return this.edicao;
    }
    
    public String getAnoPublicacao(){
        return this.anoPublicacao;
    }

    public Emprestimo getEmprestimo(int index) {
        return emprestimos.get(index);
    }

    public Reserva getReserva(int index) {
        return reservas.get(index);
    }

    public Exemplar getExemplarDisponivel() {
        for (Exemplar e : exemplares) {
            if (e.estaDisponivel()) {
                return e;
            }
        }
        return null;
    }

    public Exemplar getExemplarEmprestado(Emprestimo emprestimo) {
        for (Exemplar e : exemplares) {
            if (e.getEmprestimo().equals(emprestimo)) {
                return e;
            }
        }
        return null;
    }
}
