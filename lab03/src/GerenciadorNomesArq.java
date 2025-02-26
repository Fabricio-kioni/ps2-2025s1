import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GerenciadorNomesArq {

    public static void main(String[] args) {

        Path path = Paths.get("D:/data/Nomes.txt");
        try {
            byte[] bs = Files.readAllBytes(path);
            List<String> strings = Files.readAllLines(path);

            System.out.println("Read bytes: \n" + new String(bs));
            System.out.println("Read lines: \n" + strings);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}