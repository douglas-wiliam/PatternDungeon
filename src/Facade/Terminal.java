package Facade;

import Commands.Comando;
import Commands.NoComando;
import Business.Operations.PedidoEmprestimo;
import Commands.RealizaEmprestimoComando;
import java.util.Scanner;

/**
 *
 * @author douglas
 */
public class Terminal {

    public static String[] getKeyboardInput() {
        String input;
        String[] tokens;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        tokens = input.split(" ");

        return tokens;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] input;
        String output;
        Comando comando;
        ComandoInvocador invocador;

        System.out.println("@Biblioteca: ");
        input = getKeyboardInput();
        comando = new NoComando();
        invocador = new ComandoInvocador();

        while (!"sai".equals(input[0])) {
            switch (input[0]) {

                case "emp":
                    comando = new RealizaEmprestimoComando(new PedidoEmprestimo(input[1], input[2]));
                    break;

                case "res":
                    break;

                case "dev":
                    break;

                case "obs":
                    break;

                case "liv":
                    break;

                case "usu":
                    break;

                case "ntf":
                    break;

                default:
                    break;
            }

            output = invocador.executeCommand(comando);
            System.out.println(output);
            System.out.println("@Biblioteca: ");
            input = getKeyboardInput();
        }

        System.out.println("Usuário saiu do sistema.");
    }

}
