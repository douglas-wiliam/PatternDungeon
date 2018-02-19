package Business.Users;

import Strategy.AlunoTomarEmprestado;
import Strategy.UsuarioReservar;
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
        tomarEmprestado = new AlunoTomarEmprestado();
        reservar = new UsuarioReservar();
        emprestimos = new ArrayList();
        reservas = new ArrayList();
    }
}
