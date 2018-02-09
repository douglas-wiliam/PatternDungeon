package Business;

import Business.Operations.Emprestimo;
import Business.Operations.Reserva;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Exemplar extends Livro {

    private static ArrayList<Emprestimo> emprestimos;
    private static ArrayList<Reserva> reservas;

    public Exemplar(String codigo) {
        super(codigo);
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
}
