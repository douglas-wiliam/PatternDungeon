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
        this.livro = livro;
        this.codigo = codigo;
        this.status = "disponivel";
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
    
    public String getCodigoLivro(){
        return this.livro.getCodigo();
    }

    public String getCodigo() {
        return codigo;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public Livro getLivro() {
        return this.livro;
    }
    public String getTitulo() {
        return this.livro.getTitulo();
    }
    
    public String getEditora(){
        return this.livro.getEditora();
    }
    
    public String getAutores(){
        return this.livro.getAutores();
    }
    
    public String getEdicao(){
        return this.livro.getEdicao();
    }
    
    public String getAnoPublicacao(){
        return this.livro.getAnoPublicacao();
    }
    
    public String getStatus() {
        return this.status;
    }
}
