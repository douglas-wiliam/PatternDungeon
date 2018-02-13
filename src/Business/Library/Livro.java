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
        exemplares.add(exemplar);
    }

    public void removeExemplar(Exemplar exemplar) {
        exemplares.remove(exemplar);
    }

    public String getCodigo() {
        return codigo;
    }

    public ArrayList getExemplares() {
        return exemplares;
    }
}
