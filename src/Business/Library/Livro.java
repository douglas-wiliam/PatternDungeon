package Business.Library;

import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Livro {

    protected String codigo;
    private ArrayList<Exemplar> exemplares;

    public Livro(String codigo) {
        this.codigo = codigo;
    }

    public void addExemplar(Exemplar exemplar) {
        if (!exemplares.contains(exemplar)) {
            exemplares.add(exemplar);
        } else {
            System.out.println("Exemplar já adicionado para este livro");
        }
    }

    public void removeExemplar(Exemplar exemplar) {
        if (exemplares.contains(exemplar)) {
            exemplares.remove(exemplar);
        } else {
            System.out.println("Não existe exemplar para este livro");
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public ArrayList getExemplares() {
        return exemplares;
    }
}
