package Business.Library;

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
        if (!exemplares.contains(exemplar)) {
            exemplares.add(exemplar);
            numeroExemplares++;
        } else {
            System.out.println("Exemplar já adicionado para este livro");
        }
    }

    public void removeExemplar(Exemplar exemplar) {
        if (exemplares.contains(exemplar)) {
            exemplares.remove(exemplar);
            numeroExemplares--;
        } else {
            System.out.println("Não existe exemplar para este livro");
        }
    }

    public int getNumeroExemplares() {
        return numeroExemplares;
    }

    public String getCodigo() {
        return codigo;
    }
}
