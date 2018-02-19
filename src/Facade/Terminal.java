package Facade;

import Command.Comando;
import Command.NoComando;
import Business.Orders.Pedido;
import Command.IniciarBibliotecaComando;
import Command.RealizaCadastroObservadorComando;
import Command.RealizaCheckNotificacoesComando;
import Command.RealizaDevolucaoComando;
import Command.RealizaEmprestimoComando;
import Command.RealizaReservaComando;
import Command.RealizaConsultaUsuarioComando;
import Command.RealizaConsultaLivroComando;
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
        Comando iniciarBiblioteca = new IniciarBibliotecaComando();
        ComandoInvocador invocador;
        comando = new NoComando();
        invocador = new ComandoInvocador();
        System.out.print("@Biblioteca: ");
        input = getKeyboardInput();

        invocador.executeCommand(iniciarBiblioteca);

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
                    comando = new RealizaConsultaLivroComando(input[1]);
                    break;

                case "usu":
                    comando = new RealizaConsultaUsuarioComando(input[1]);
                    break;

                case "ntf":
                    comando = new RealizaCheckNotificacoesComando(input[1]);
                    break;

                default:
                    break;
            }

            output = invocador.executeCommand(comando);
            System.out.println(output);
            System.out.print("@Biblioteca: ");
            input = getKeyboardInput();
        }

        System.out.println("Usuário saiu do sistema.");
    }
}
