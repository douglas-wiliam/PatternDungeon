package Validate;

import Business.Library.Biblioteca;
import Business.Library.Livro;
import Business.Orders.Pedido;
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
            if (livro.getExemplares().isEmpty()) {
                log = "Sem exemplares disponíveis na Biblioteca";
            }
        }
    }

    @Override
    public String getLog() {
        return log;
    }

}
