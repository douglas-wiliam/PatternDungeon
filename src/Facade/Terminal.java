package Facade;

import Commands.Comando;
import Commands.NoComando;
import Business.Orders.Pedido;
import Commands.RealizaCadastroObservadorComando;
import Commands.RealizaDevolucaoComando;
import Commands.RealizaEmprestimoComando;
import Commands.RealizaReservaComando;
import Commands.RealizaConsultaUsuarioComando;
import java.util.Scanner;

/**
 *
 * @author douglas, Guilherme e amigo Fábio
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
                    comando = new RealizaEmprestimoComando(new Pedido(input[1], input[2]));
                    break;

                case "res":
                    comando = new RealizaReservaComando(new Pedido(input[1], input[2]));
                    break;

                case "dev":
                    comando = new RealizaDevolucaoComando(new Pedido(input[1], input[2]));
                    break;

                case "obs":
                    comando = new RealizaCadastroObservadorComando(new Pedido(input[1],input[2]));
                    break;

                case "liv":
                    break;

                case "usu":
                    comando = new RealizaConsultaUsuarioComando(input[1]);
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
