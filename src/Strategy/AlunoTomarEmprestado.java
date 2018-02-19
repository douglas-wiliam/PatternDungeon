package Strategy;

import Business.Library.Livro;
import Business.Operations.Emprestimo;
import Business.Users.Usuario;

/**
 *
 * @author douglas
 */
public class AlunoTomarEmprestado implements TomarEmprestadoBehavior {

    @Override
    public String tomarEmprestado(Usuario usuario, Livro livro) {

        if (!livro.temExemplarDisponivel()) {   // Exigencia 1
            return "Insucesso em Operação de Empréstimo: Exemplar não Disponivel na Biblioteca";
        }

        if (usuario.estaDevedor()) {    // Exigencia 2
            return "Insucesso em Operação de Empréstimo: Usuário devedor de livro em atraso";
        }

        if ((usuario.getQtdEmprestimos() + 1) > usuario.getQtdMaxEmprestimos()) { // Exigencia 3
            return "Insucesso em Operação de Empréstimo: Quantidade máxima de empréstimos excedida";
        }

        if (livro.getQtdReservas() >= livro.getQtdExemplaresDisponiveis()) { // Exigencia 4
            if (!usuario.temLivroReservado(livro)) {    // Exigencia 5
                return "Insucesso em Operação de Empréstimo: Existem reservas na sua frente";
            }
        }

        if (usuario.temLivroEmprestado(livro)) {    // Exigencia 6
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
