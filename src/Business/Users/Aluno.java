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
        this.periodoEmprestimo = 5;
        this.emprestimos = new ArrayList();
    }
}
