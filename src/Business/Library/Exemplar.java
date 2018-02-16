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
    }

    public void empresta(Emprestimo emprestimo) {
        status = "emprestado";
        this.emprestimo = emprestimo;
    }

    public void devolve() {
        status = "disponivel";
        emprestimo = null;
    }

    public String getStatus() {
        return status;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

}
