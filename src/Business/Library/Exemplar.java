package Business.Library;

import Business.Operations.Emprestimo;

/**
 *
 * @author douglas
 */
public class Exemplar extends Livro {

    private String status; // "disponivel" ou "emprestado"
    private Emprestimo emprestimo;  // O emprestimo vinculado

    public Exemplar(String codigo) {
        super(codigo);
        status = "disponivel";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

}
