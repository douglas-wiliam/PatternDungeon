package Business.Library;

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
        if (!emprestimos.contains(emprestimo)) {
            emprestimos.add(emprestimo);
        } else {
            System.out.println("Emprestimo já existe para este exemplar");
        }
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void addReserva(Reserva reserva) {
        if (!reservas.contains(reserva)) {
            reservas.add(reserva);
        } else {
            System.out.println("Reserva já existe para este exemplar");
        }
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
}
