package Command;

import Business.Library.Biblioteca;
import Business.Library.Livro;
import Facade.Fachada;

/**
 *
 * @author douglas
 */
public class RealizaConsultaLivroComando implements Comando {

    private final String codigoLivro;

    public RealizaConsultaLivroComando(String codigoLivro) {
        this.codigoLivro = codigoLivro;
    }

    @Override
    public String execute() {
        return Fachada.realizaConsultaLivro(codigoLivro);
    }
}