package Business.Library;

import Business.Operations.Emprestimo;

/**
 *
 * @author douglas
 */
public class Exemplar {

    private final String codigo;
    private String status; // "disponivel" ou "emprestado"
    private Emprestimo emprestimo;  // O emprestimo vinculado
    private final Livro livro;

    public Exemplar(Livro livro, String codigo) {
        this.codigo = codigo;
        this.livro = livro;
    }

    public void empresta(Emprestimo emprestimo) {
        status = "emprestado";
        this.emprestimo = emprestimo;
    }

    public void devolve() {
        status = "disponivel";
        emprestimo = null;
    }

    public boolean estaDisponivel() {
        return status.equals("disponivel");
    }

    public String getCodigo() {
        return codigo;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public Livro getLivro() {
        return livro;
    }
}
