package Business.Users;

import Business.Library.Livro;
import Business.Library.Exemplar;
import Business.Operations.Emprestimo;
import Business.Operations.Reserva;
import Strategy.TomarEmprestadoBehavior;
import Strategy.ReservarBehavior;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public abstract class Usuario {

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

    public String reserva(Livro livro) {
        return reservar.reservar(this, livro);
    }

    public String devolve(Livro livro) {
        for (Emprestimo e : emprestimos) {
            if (livro.getExemplarEmprestado(e) != null) {
                e.fechaEmprestimo();
                return "Sucesso em Operação de Devolução";
            }
        }

        return "Insucesso em Operação de Devolução: Não Existe Empréstimo em Aberto para o Livro";
    }
    
    public String consulta(){
        String output;
        output = "Nome: " + this.getNome() + "\n";
        output += "Emprestimos:\n";
        StringBuilder strBuilder = new StringBuilder(output);
        for (Emprestimo e : emprestimos){
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
        for (Reserva r : reservas){
            strBuilder.append("\tTitulo: ");
            strBuilder.append(r.getTituloLivro());
            strBuilder.append("\n");
            strBuilder.append("\tData de Solicitacao: ");
            strBuilder.append(r.getDataSolicitacao());
            strBuilder.append("\n\n"); 
        }
        return output;
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
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

    public Emprestimo getEmprestimo(int index) {
        return emprestimos.get(index);
    }

    public Reserva getReserva(int index) {
        return reservas.get(index);
    }
}
