package Facade;

/**
 *
 * @author douglas
 */
public class Fachada {

    private static Fachada uniqueInstance;

    private Fachada() {
    }

    public static synchronized Fachada getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Fachada();
        }
        return uniqueInstance;
    }

    public static String realizaEmprestimo(String codigoUsuario, String codigoLivro) {
        // Implementar
        return "Realizar Empréstimo não Implementado";
    }
}
