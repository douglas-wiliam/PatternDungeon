package Business.Users;

import Strategy.ProfessorTomarEmprestado;
import Strategy.UsuarioReservar;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Professor extends Usuario {

    public Professor(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        periodoEmprestimo = 7;
        qtdMaxEmprestimos = 1000;   // Professores nao tem limites de emprestimo
        qtdMaxReservas = 3;
        tomarEmprestado = new ProfessorTomarEmprestado();
        reservar = new UsuarioReservar();
        emprestimos = new ArrayList();
        reservas = new ArrayList();
    }
}
