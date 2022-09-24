import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Freq implements Command {
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {
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
            System.out.println();


        } catch (IOException exception) {
            System.out.println("Unreadable file: "+exception);
        }
        return false;
    }
}
