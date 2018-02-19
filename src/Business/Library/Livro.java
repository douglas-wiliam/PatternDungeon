package Business.Library;

import Business.Operations.Emprestimo;
import Business.Operations.Reserva;
import Business.Users.Usuario;
import Observer.Sujeito;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Livro implements Sujeito {

    private final String codigo;
    private final String titulo;
    private final String editora;
    private final String autores;
    private final String edicao;
    private final String anoPublicacao;

    private ArrayList<Exemplar> exemplares;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Reserva> reservas;
    private ArrayList<Usuario> observadores;

    public Livro(String codigo, String titulo, String editora, String autores, String edicao, String ano) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = ano;
        this.reservas = new ArrayList();
        this.observadores = new ArrayList();
        this.emprestimos = new ArrayList();
        this.exemplares = new ArrayList();
    }

    public void addExemplar(String codigo) {
        exemplares.add(new Exemplar(this, codigo, "disponivel"));
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
        if (reservas.size() == 2) {
            this.atualizaObservadores();
        }
    }

    public String addObservador(Usuario usuario) {
        observadores.add(usuario);
        return "Observador Adicionado";
    }

    public void removeExemplar(String codigo) {
        for (Exemplar e : exemplares) {
            if (codigo.equals(e.getCodigo())) {
                exemplares.remove(e);
            }
        }
    }

    public void fechaReserva(Usuario usuario) {
        Reserva res = null;
        for (Reserva r : reservas) {
            if (r.getUsuario() == usuario) {
                res = r;
            }
        }
        if (res != null) {
            reservas.remove(res);
        }
    }

    @Override
    public void atualizaObservadores() {
        for (Usuario obs : observadores) {
            obs.notifica();
        }
    }

    public boolean temExemplarDisponivel() {
        for (Exemplar e : exemplares) {
            if (e.estaDisponivel()) {
                return true;
            }
        }
        return false;
    }

    public boolean temEmprestimo(Emprestimo emprestimo) {
        for (Exemplar e : exemplares) {
            if (e.getEmprestimo() != null) {
                if (e.getEmprestimo().equals(emprestimo)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getEditora() {
        return this.editora;
    }

    public String getAutores() {
        return this.autores;
    }

    public String getEdicao() {
        return this.edicao;
    }

    public String getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public Emprestimo getEmprestimo(int index) {
        return emprestimos.get(index);
    }

    public Reserva getReserva(int index) {
        return reservas.get(index);
    }

    public ArrayList<Reserva> getReservas() {
        return this.reservas;
    }

    public ArrayList<Exemplar> getExemplares() {
        return this.exemplares;
    }

    public Exemplar getExemplarDisponivel() {
        for (Exemplar e : exemplares) {
            if (e.estaDisponivel()) {
                return e;
            }
        }
        return null;
    }

    public int getQtdReservas() {
        if (reservas.isEmpty()) {
            return 0;
        }
        return reservas.size();
    }

    public int getQtdExemplaresDisponiveis() {
        int cont = 0;
        for (Exemplar e : exemplares) {
            if (e.estaDisponivel()) {
                cont++;
            }
        }
        return cont;
    }

    public String consulta() {
        int quantidadeReservas = this.getQtdReservas();
        int quantidadeExemplares = this.getExemplares().size();
        String output;

        output = "Titulo: " + this.getTitulo() + " \n";
        output += "\tReservas: " + quantidadeReservas + " \n";
        if (quantidadeReservas > 0) {
            output += "\tReservado por: ";
            for (Reserva r : this.getReservas()) {
                output += r.getUsuario().getNome() + ", ";
            }
            output += "\n\n";
        }

        output += "\tExemplares:\n";
        if (quantidadeExemplares > 0) {
            for (Exemplar e : this.getExemplares()) {
                if ("disponivel".equals(e.getStatus())) {
                    output += "\t[" + e.getCodigo() + "]" + " - " + e.getStatus();
                } else {
                    output += "\t[" + e.getCodigo() + "] - " + e.getEmprestimo().toString();
                }
                output += "\n";
            }
        }

        return output;
    }

    public void setExemplares(ArrayList<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }
}
