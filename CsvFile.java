import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class CsvFile {

    public void read_coulmn() throws IOException {

        File file = new File("database.csv");
        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        for (String line : lines) {
            String[] array = line.split(";");
            System.out.println(array[0] + " " + array[array.length - 1]);
        }
    }

    /**
     * @return
     * @throws IOException
     */
    String[] array;
    public String[] read() throws IOException {
        File file = new File("database.csv");
        Object[] obj;
        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        for (String line : lines) {
            array = line.split(",");
            System.out.println(array[8]);
        }
        for (String string : array) {
            System.out.println(string);
        }

        return array;

    }
}