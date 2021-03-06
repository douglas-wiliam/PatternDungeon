package Strategy;

import Business.Library.Livro;
import Business.Operations.Emprestimo;
import Business.Users.Usuario;

/**
 *
 * @author douglas
 */
public class ProfessorTomarEmprestado implements TomarEmprestadoBehavior {

    @Override
    public String tomarEmprestado(Usuario usuario, Livro livro) {
        if (!livro.temExemplarDisponivel()) {
            return "Insucesso em Operação de Empréstimo: Exemplar não Disponivel na Biblioteca";
        }

        if (usuario.temLivroEmprestado(livro)) {
            return "Insucesso em Operação de Empréstimo: Usuário possui empréstimo em aberto do livro";
        }

        if (usuario.temLivroReservado(livro)) {
            usuario.fechaReserva(livro);
            livro.fechaReserva(usuario);
        }

        Emprestimo emprestimo = new Emprestimo(usuario, livro.getExemplarDisponivel());
        emprestimo.abreEmprestimo();

        livro.addEmprestimo(emprestimo);
        usuario.addEmprestimo(emprestimo);
        return "Sucesso: Livro " + livro.getTitulo() + " emprestado para " + usuario.getNome();
    }

}
