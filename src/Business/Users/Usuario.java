package Business.Users;

import Business.Library.Livro;
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
