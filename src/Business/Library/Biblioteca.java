package Business.Library;

import Business.Users.Aluno;
import Business.Users.Funcionario;
import Business.Users.Professor;
import Business.Users.Usuario;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Biblioteca {

    private static Biblioteca uniqueInstance;
    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Livro> livros;

    private Biblioteca() {

    }

    public static synchronized Biblioteca getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Biblioteca();
        }

        return uniqueInstance;
    }

    public static Usuario buscaUsuario(String codigoUsuario) {
        for (Usuario u : usuarios) {
            if (u.getCodigo().equals(codigoUsuario)) {
                return u;
            }
        }
        return null;
    }

    public static Livro buscaLivro(String codigoLivro) {
        for (Livro l : livros) {
            if (l.getCodigo().equals(codigoLivro)) {
                return l;
            }
        }
        return null;
    }

    public static void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static void addLivro(Livro livro) {
        livros.add(livro);
    }

    public static void removeUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public static void removeLivro(Livro livro) {
        livros.remove(livro);
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static ArrayList<Livro> getLivros() {
        return livros;
    }
    
    public static void preencherUsuarios() {
        usuarios = new ArrayList<Usuario>();
        addUsuario(new Funcionario("João da Silva", "123"));
        addUsuario(new Aluno("Luiz Fernando Rodrigues", "456"));
        addUsuario(new Funcionario("Pedro Paulo", "789"));
        addUsuario(new Professor("Carlos Lucena", "100"));
    }

    public static void preencherLivros() {
        livros = new ArrayList<Livro>();
        addLivro(new Livro("100", "Engenharia de Software", "Addison Wesley", "Ian Sommervile", "6a", "2000"));
        addLivro(new Livro("101", "UML - Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", "7a", "2000"));
        addLivro(new Livro("200", "Code Complete", "Microsoft Press", "Steve McConnell", "2a", "2014"));
        addLivro(new Livro("201", "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", "Robert Martin", "1a", "2002"));
        addLivro(new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", "Martin Fowler", "1a", "1999"));
        addLivro(new Livro("301", "Software Metrics: A Rigorous and Practical Approach", "CRC Press", "Norman Fenton, James Bieman", "3a", "2014"));
        addLivro(new Livro("400", "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1a", "1994"));
        addLivro(new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professional", "Martin Fowler", "3a", "2003"));
    }

    public static void preencherExemplares() {
        for(Livro l : livros)
            l.setExemplares(new ArrayList<Exemplar>());
        
        buscaLivro("100").addExemplar("01");
        buscaLivro("100").addExemplar("02");
        buscaLivro("101").addExemplar("03");
        buscaLivro("200").addExemplar("04");
        buscaLivro("201").addExemplar("05");
        buscaLivro("300").addExemplar("06");
        buscaLivro("300").addExemplar("07");
        buscaLivro("400").addExemplar("08");
        buscaLivro("400").addExemplar("09");
    }

}
