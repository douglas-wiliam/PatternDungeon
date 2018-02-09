package Business;

import Business.Operations.Emprestimo;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Livro {

    public int numeroExemplares;
    private static ArrayList<Emprestimo> emprestimos;

    public Livro(int numeroExemplares) {
        this.numeroExemplares = numeroExemplares;
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public int getNumeroExemplares() {
        return numeroExemplares;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setNumeroExemplares(int numeroExemplares) {
        this.numeroExemplares = numeroExemplares;
    }
}
