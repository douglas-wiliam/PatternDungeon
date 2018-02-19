package Commands;

import Business.Library.Biblioteca;
import Business.Library.Livro;
import Facade.Fachada;

/**
 *
 * @author douglas
 */
public class RealizaConsultaLivroComando implements Comando {

    private final Livro livro;

    public RealizaConsultaLivroComando(String codigoLivro) {
        this.livro = Biblioteca.buscaLivro(codigoLivro);
    }

    @Override
    public String execute() {
        return Fachada.realizaConsultaLivro(this.livro);
    }
}