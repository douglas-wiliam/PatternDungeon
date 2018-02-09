package Business.Library;

import Business.Operations.Emprestimo;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Livro {

    protected String codigo;
    private int numeroExemplares;
    private ArrayList<Exemplar> exemplares;

    public Livro(String codigo) {
        this.codigo = codigo;
        numeroExemplares = 0;
    }

    public void addExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
        numeroExemplares++;
    }

    public void removeExemplar(Exemplar exemplar) {
        if (exemplares.contains(exemplar)) {
            exemplares.remove(exemplar);
            numeroExemplares--;
        }
    }

    public int getNumeroExemplares() {
        return numeroExemplares;
    }

    public String getCodigo() {
        return codigo;
    }
}
