package Commands;

import Facade.Fachada;
import Business.Emprestimo;

/**
 *
 * @author douglas
 */
public class RealizaEmprestimoComando implements Comando {

    private Emprestimo emprestimo;

    public RealizaEmprestimoComando(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    @Override
    public String execute() {
        return Fachada.realizaEmprestimo(emprestimo.getCodigoUsuario(), emprestimo.getCodigoLivro());
    }

}
