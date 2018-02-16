package Business.Users;

import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Aluno extends Usuario {

    public Aluno(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        periodoEmprestimo = 5;
        qtdMaxEmprestimos = 4;
        qtdMaxReservas = 3;
        emprestimos = new ArrayList();
        reservas = new ArrayList();

    }
}
