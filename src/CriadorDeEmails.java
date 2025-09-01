import java.util.*;

public class CriadorDeEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> contadorEmails = new HashMap<>();

        while (true) {
            System.out.print("Digite o nome completo (ou 'sair' para encerrar): ");
            String nomeCompleto = sc.nextLine().trim();

            if (nomeCompleto.equalsIgnoreCase("sair")) {
                break;
            }

            String[] partes = nomeCompleto.toLowerCase().split("\\s+");
            String nome = partes[0];
            String sobrenome = partes[partes.length - 1];

            String emailBase = nome + "." + sobrenome;
            String emailFinal;

            if (contadorEmails.containsKey(emailBase)) {
                int numero = contadorEmails.get(emailBase) + 1;
                contadorEmails.put(emailBase, numero);
                emailFinal = emailBase + numero + "@empresa.com";
            } else {
                contadorEmails.put(emailBase, 1);
                emailFinal = emailBase + "@empresa.com";
            }

            System.out.println("Email gerado: " + emailFinal);
        }

        sc.close();
    }
}