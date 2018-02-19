package Strategy;

import Business.Library.Livro;
import Business.Users.Usuario;
import Business.Operations.Reserva;

/**
 *
 * @author douglas
 */
public class UsuarioReservar implements ReservarBehavior {

    @Override
    public String reservar(Usuario usuario, Livro livro) {
        if (usuario.getQtdReservas() == usuario.getQtdMaxReservas()){
            return "Insucesso: Quantidade maxima de reservas alcançada.";
        }
        if (usuario.temReservaLivro(livro)){
            return "Insucesso: Usuario já tem uma reserva desse livro.";
        }
        if (usuario.temLivroEmprestado(livro)){
            return "Insucesso: Usuario já tem esse livro.";
        }
        Reserva reserva = new Reserva(usuario, livro);
        usuario.addReserva(reserva);
        livro.addReserva(reserva);
        return "Sucesso: Livro "+livro.getTitulo()+" reservado para "+usuario.getNome();
    }

}
