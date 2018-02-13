package Business.Library;

import Business.Operations.Emprestimo;
import Business.Operations.Reserva;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Exemplar extends Livro {

    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Reserva> reservas;

    public Exemplar(String codigo) {
        super(codigo);
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

}
