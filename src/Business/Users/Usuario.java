package Business.Users;

import Business.Library.Livro;
import Business.Operations.Emprestimo;
import Business.Operations.Reserva;
import Observer.Observador;
import Strategy.TomarEmprestadoBehavior;
import Strategy.ReservarBehavior;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public abstract class Usuario implements Observador{

    protected String nome;
    protected String codigo;
    protected int notificacoes;
    protected int periodoEmprestimo;
    protected int qtdMaxEmprestimos;
    protected int qtdMaxReservas;
    protected TomarEmprestadoBehavior tomarEmprestado;
    protected ReservarBehavior reservar;
    protected ArrayList<Emprestimo> emprestimos;
    protected ArrayList<Reserva> reservas;

    public String tomaEmprestado(Livro livro) {
        return tomarEmprestado.tomarEmprestado(this, livro);
    }

    public String reservar(Livro livro) {
        return reservar.reservar(this, livro);
    }
    
    public void fechaReserva(Livro livro){
        for (Reserva r : reservas){
            if (r.getLivro() == livro){
                reservas.remove(r);
            }
        }
    }

    public String devolve(Livro livro) {
        for (Emprestimo e : emprestimos) {
            if (e.estaAberto()  && livro.temEmprestimo(e)) {
                e.fechaEmprestimo();
                return "Sucesso em Operação de Devolução";
            }
        }

        return "Insucesso em Operação de Devolução: Não Existe Empréstimo em Aberto para o Livro";
    }

    public String consulta() {
        String output;
        output = "Nome: " + this.getNome() + "\n";
        output += "Emprestimos:\n";
        StringBuilder strBuilder = new StringBuilder(output);
        for (Emprestimo e : emprestimos) {
            strBuilder.append("\tTitulo: ");
            strBuilder.append(e.getTituloExemplar());
            strBuilder.append("\n");
            strBuilder.append("\tData de emprestimo: ");
            strBuilder.append(e.getDataCriacao());
            strBuilder.append("\n");
            strBuilder.append("\tStatus: ");
            strBuilder.append(e.getStatus());
            strBuilder.append("\n");
            strBuilder.append("\tData de devolucao: ");
            strBuilder.append(e.getDataDevolucao());
            strBuilder.append("\n\n");
        }
        output += "Reservas:\n";
        for (Reserva r : reservas) {
            strBuilder.append("\tTitulo: ");
            strBuilder.append(r.getTituloLivro());
            strBuilder.append("\n");
            strBuilder.append("\tData de Solicitacao: ");
            strBuilder.append(r.getDataSolicitacao());
            strBuilder.append("\n\n");
        }
        return output;
    }
    
    @Override
    public void notifica(){
        this.notificacoes += 1;
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public boolean temLivroEmprestado(Livro livro) {
        for (Emprestimo e : emprestimos) {
            if (e.estaAberto() && e.getCodigoLivro().equals(livro.getCodigo())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean temReservaLivro(Livro livro){
        for (Reserva r : reservas){
            if (livro == r.getLivro()){
                return true;
            }
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public String getNotificacoes(){
        return String.valueOf(this.notificacoes);
    }

    public int getPeriodoEmprestimo() {
        return periodoEmprestimo;
    }

    public int getQtdMaxEmprestimos() {
        return qtdMaxEmprestimos;
    }

    public int getQtdMaxReservas() {
        return qtdMaxReservas;
    }
    
    public int getQtdReservas(){
        return reservas.size();
    }
}
