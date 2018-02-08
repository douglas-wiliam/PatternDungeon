package Business;

/**
 *
 * @author douglas
 */
public class Biblioteca {

    private static Biblioteca uniqueInstance;

    private Biblioteca() {

    }

    public static synchronized Biblioteca getInstance() {
        if(uniqueInstance == null)
            uniqueInstance = new Biblioteca();
        
        return uniqueInstance;
    }
}
