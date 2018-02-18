package Business.Users;

import Strategy.AlunoTomarEmprestado;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Funcionario extends Usuario {

    public Funcionario(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        periodoEmprestimo = 2;
        qtdMaxEmprestimos = 3;
        qtdMaxReservas = 3;
        tomarEmprestado = new AlunoTomarEmprestado();
        emprestimos = new ArrayList();
        reservas = new ArrayList();
    }
}
