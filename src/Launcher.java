import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bonjour et bienvenue sur ce code !");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                switch (scanner.nextLine().toLowerCase()){
                    case "quit":
                        return;
                    case "fibo":
                        System.out.println("Entrez un nombre :");
                        if(scanner.hasNextInt()){
                            int num = scanner.nextInt();
                            try {
                                System.out.println("Fibonacci de "+num+" est "+fibo(num));
                            }catch (StackOverflowError ignored){
                                System.out.println("Erreur : Vous avez entré un nombre trop grand.");
                            }
                        }else{
                            System.out.println("Erreur : Vous n'avez pas entré un nombre valide.");
                        }
                        scanner.nextLine();
                        break;
                    case "freq":

                        break;
                    default:
                        System.out.println("Unknown command");
                        break;
                }
            }
        }
    }
    public static int fibo(int n){
        int f0 = 0;
        int f1 = 1;
        int fn = -1;
        if (n == 0){
            fn = f0;
        }
        if (n == 1){
            fn = f1;
        }
        for (int k = 2; k <= n; ++k){
            fn = f1 + f0;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}
