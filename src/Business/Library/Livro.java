package Business.Library;

import Business.Operations.Emprestimo;
import Business.Operations.Reserva;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Livro {

    private final String codigo;
    private ArrayList<Exemplar> exemplares;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Reserva> reservas;

    public Livro(String codigo) {
        this.codigo = codigo;
    }

    public void addExemplar(String codigo) {
        exemplares.add(new Exemplar(this, codigo));
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
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

    public Emprestimo getEmprestimo(int index) {
        return emprestimos.get(index);
    }

    public Reserva getReserva(int index) {
        return reservas.get(index);
    }

    public Exemplar getExemplarDisponivel() {
        for (Exemplar e : exemplares) {
            if ("disponivel".equals(e.getStatus())) {
                return e;
            }
        }
        return null;
    }
}
