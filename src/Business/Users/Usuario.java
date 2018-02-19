package Business.Users;

import Business.Library.Livro;
import Business.Operations.Emprestimo;
import Business.Operations.Reserva;
import Observer.Observador;
import Strategy.TomarEmprestadoBehavior;
import Strategy.ReservarBehavior;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public abstract class Usuario implements Observador {

    protected String nome;
    protected String codigo;
    protected int notificacoes;
    protected int periodoEmprestimo;
    protected int qtdMaxEmprestimos;
    protected int qtdMaxReservas;
    protected TomarEmprestadoBehavior tomarEmprestado;
    protected ReservarBehavior reservar;
    protected ArrayList<Emprestimo> emprestimos;
    protected ArrayList<Reserva> reservas;

    public String tomaEmprestado(Livro livro) {
        return tomarEmprestado.tomarEmprestado(this, livro);
    }

    public String reservar(Livro livro) {
        return reservar.reservar(this, livro);
    }

    public void fechaReserva(Livro livro) {
        Reserva res = null;
        for (Reserva r : reservas) {
            if (r.getLivro() == livro) {
                res = r;
            }
        }
        if (res != null){
            reservas.remove(res);
        }
    }

    public String devolve(Livro livro) {
        for (Emprestimo e : emprestimos) {
            if (e.estaAberto() && livro.temEmprestimo(e)) {
                e.fechaEmprestimo();
                return "Sucesso em Operação de Devolução";
            }
        }

        return "Insucesso em Operação de Devolução: Não Existe Empréstimo em Aberto para o Livro";
    }

    public String consulta() {
        String output;
        output = "Nome: " + this.getNome() + "\n";
        output += "Emprestimos:\n";
        for (Emprestimo e : emprestimos) {
            output += "\tTitulo: "+e.getTituloExemplar()+"\n";
            output += "\tData de emprestimo: "+e.getDataCriacao()+"\n";
            output += "\tStatus: "+e.getStatus()+"\n";
            output += "\tData de devolucao: "+e.getDataDevolucao()+"\n\n";
        }
        output += "Reservas:\n";
        for (Reserva r : reservas) {
            output += "\tTitulo: "+r.getTituloLivro()+"\n";
            output += "\tData de Solicitacao: "+r.getDataSolicitacao()+"\n\n";
        }
        return output;
    }

    @Override
    public void notifica() {
        this.notificacoes += 1;
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    private LocalDate geraDataAtual() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAtual = LocalDate.now();

        return dataAtual;
    }

    public boolean estaDevedor() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate dataAtual = geraDataAtual();
        LocalDate dataDevolucao;

        for (Emprestimo e : emprestimos) {
            if (e.estaAberto()) {
                dataDevolucao = LocalDate.parse(e.getDataDevolucao(), dtf);
                if (dataDevolucao.isBefore(dataAtual)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean temLivroEmprestado(Livro livro) {
        for (Emprestimo e : emprestimos) {
            if (e.estaAberto() && e.getCodigoLivro().equals(livro.getCodigo())) {
                return true;
            }
        }
        return false;
    }

    public boolean temLivroReservado(Livro livro) {
        for (Reserva r : reservas) {
            if (r.getCodigoLivro().equals(livro.getCodigo())) {
                return true;
            }
        }
        return false;
    }

    public boolean temReservaLivro(Livro livro) {
        for (Reserva r : reservas) {
            if (livro == r.getLivro()) {
                return true;
            }
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNotificacoes() {
        return String.valueOf(this.notificacoes);
    }

    public int getPeriodoEmprestimo() {
        return periodoEmprestimo;
    }

    public int getQtdMaxEmprestimos() {
        return qtdMaxEmprestimos;
    }

    public int getQtdEmprestimos() {
        int Qtd = 0;
        for (Emprestimo e : emprestimos){
            if (e.estaAberto()){
                Qtd += 1;
            }
        }
        return Qtd;
    }

    public int getQtdMaxReservas() {
        return qtdMaxReservas;
    }

    public int getQtdReservas() {
        return reservas.size();
    }
}
