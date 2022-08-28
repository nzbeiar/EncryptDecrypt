package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Message {
    static final int INPUT_OFFSET = 1;
    public String mode = "enc";
    public int key = 0;
    public String in = "";
    public String out = "";
    public String data = "";
    public String alg = "shift";

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public Message(String[] args) {
        List<String> list = new ArrayList<>(List.of(args));
        if (list.contains("-mode")) {
            this.mode = list.get(list.indexOf("-mode") + INPUT_OFFSET);
        }
        if (list.contains("-key")) {
            this.key = Integer.parseInt(list.get(list.indexOf("-key") + INPUT_OFFSET));
        }
        if (list.contains("-in")) {
            this.in = list.get(list.indexOf("-in") + INPUT_OFFSET);
        }
        if (list.contains("-data")) {
            this.data = list.get(list.indexOf("-data") + INPUT_OFFSET);
        }
        if (list.contains("-out")) {
            this.out = list.get(list.indexOf("-out") + INPUT_OFFSET);
        }
        if (list.contains("-alg")) {
            this.alg = list.get(list.indexOf("-alg") + INPUT_OFFSET);
        }

    }

    public String getInput() {
        if (!in.isEmpty() && data.isEmpty()) {
            try {
                data = readFileAsString(in);
            } catch (IOException e) {
                System.out.println("An Error! Cannot read file: " + e.getMessage());
            }
        }
        return data;
    }

    public void produceOutput(String data) {
        if (!out.isEmpty()) {
            try {
                File file = new File(out);
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(data);
                }
            } catch (IOException e) {
                System.out.printf("An Error occurred %s", e.getMessage());
            }
        } else {
            System.out.println(data);
        }
    }
}