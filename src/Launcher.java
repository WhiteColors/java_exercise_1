import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bonjour et bienvenue sur ce code !");
        try (Scanner scanner = new Scanner(System.in)) {
            while (!scanner.nextLine().equalsIgnoreCase("quit")) {
                System.out.println("Unknow command");
            }
        }
    }
}
