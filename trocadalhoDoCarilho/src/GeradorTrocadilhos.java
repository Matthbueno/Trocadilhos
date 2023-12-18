import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GeradorTrocadilhos {
    public static void main(String[] args) {
        int opcao;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Trocadalho do Carilho!\n"
                    + "Lê um trocadalho ai meu chapa\n");
            System.out.println("\n");
            System.out.println("Escolha uma opção");
            System.out.println("1- Ler um trocadilho");
            System.out.println("2- Adicionar trocadilho");
            System.out.println("3- Finalizar programa!");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    lerTrocadilho1(scanner);
                    break;
                case 2:
                    addTrocadilho(scanner);
                    break;
                case 3:
                    System.out.println("Finalizando programa!");
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }

        } while (opcao != 2);

        scanner.close();
    }

    public static void lerTrocadilho1(Scanner scanner) {
        String nomeArquivo = "trocadilhos.txt";
        List<String> trocadilhos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                trocadilhos.add(linha);

            }
            if (!trocadilhos.isEmpty()) {
                Random random = new Random();
                int lerAleatorio = random.nextInt(trocadilhos.size());
                System.out.println("\\\n + Trocadilho!:" + trocadilhos.get(lerAleatorio));
            } else {
                System.out.println("Não há piadas para listar.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o Arquivo" + e.getMessage());
        }
    }

    public static void addTrocadilho(Scanner scanner) {
        System.out.println("Digite um trocadilho: ");
        String textoUsuario = scanner.nextLine();
        String nomeArquivo = "trocadilhos.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(textoUsuario);
            writer.newLine();
            System.out.println("trocadilho Adicionado! ");

        } catch (IOException e) {
            System.err.println("ERRO ao adicionar trocadilho!");
        }
    }

}
