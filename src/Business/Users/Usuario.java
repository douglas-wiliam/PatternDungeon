package Business.Users;

import Business.Operations.Emprestimo;
import Business.Orders.Pedido;
import Business.Operations.Reserva;
import Validate.Checker;
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
    protected Pedido pedido;
    protected ArrayList<Emprestimo> emprestimos;
    protected ArrayList<Reserva> reservas;
    protected ArrayList<Checker> checkers;

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

    public Pedido getPedido() {
        return pedido;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public ArrayList<Checker> getCheckers() {
        return checkers;
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void addCheckers(Checker checker) {
        checkers.add(checker);
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
