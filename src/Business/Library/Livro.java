package Business.Library;

import Business.Operations.Emprestimo;
import Business.Operations.Reserva;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Livro {

    protected String codigo;
    private ArrayList<Exemplar> exemplares;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Reserva> reservas;

    public Livro(String codigo) {
        this.codigo = codigo;
    }

    public void addExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void removeExemplar(Exemplar exemplar) {
        exemplares.remove(exemplar);
    }

    public String getCodigo() {
        return codigo;
    }

    public ArrayList<Exemplar> getExemplares() {
        return exemplares;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
