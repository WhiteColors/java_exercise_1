import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

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
                        System.out.println("Entrez le chemin d'accès au fichier texte :");
                        try{
                            String content = Files.readString(Path.of(scanner.nextLine()));
                            Stream<String> keys = Arrays.stream(content.replaceAll("[,.;:?']"," ").replaceAll("\n", "").toLowerCase().split(" "));
                            HashMap<String, Integer> occurence = new HashMap<>();
                            for(String value : keys.toList()){
                                if(value.isBlank()){
                                    continue;
                                }
                                if(!occurence.containsKey(value)){
                                    occurence.put(value, 1);
                                }else{
                                    occurence.put(value, occurence.get(value)+1);
                                }
                            }
                            for(int i=0;i<3;i++) {
                                int max = -1;
                                String name = null;
                                for (Map.Entry<String, Integer> res : occurence.entrySet()) {
                                    if(res.getValue()>max){
                                        max = res.getValue();
                                        name = res.getKey();
                                    }
                                }
                                System.out.print(name+" ");
                                occurence.values().remove(max);
                            }


                        } catch (IOException exception) {
                            System.out.println("Unreadable file: "+exception);
                        }
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
