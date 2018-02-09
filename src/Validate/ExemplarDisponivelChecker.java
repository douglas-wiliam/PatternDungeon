package Validate;

import Business.Biblioteca;
import Business.Livro;
import Business.Operations.Pedido;
import Business.Users.Usuario;

/**
 *
 * @author douglas
 */
public class ExemplarDisponivelChecker implements Checker {

    private String log;
    private Usuario usuario;
    private Pedido pedido;

    public ExemplarDisponivelChecker(Usuario usuario) {
        log = "";
        this.usuario = usuario;
    }

    @Override
    public void check() {
        pedido = usuario.getPedido();
        Livro livro = Biblioteca.buscaLivro(pedido.getCodigoLivro());

        if (livro == null) {
            log = "Livro não disponível na Biblioteca";
        } else {
            if (livro.getNumeroExemplares() == 0) {
                log = "Sem exemplares disponíveis na Biblioteca";
            }
        }
    }

    @Override
    public String getLog() {
        return log;
    }

}
