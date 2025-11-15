package java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NewFileMethods {

    public static void main(String[] args) throws IOException {
        Example.example();
    }

}

class Example {

    public static void example() throws IOException {
        Path newFile = Files.createTempFile("demo", ".txt");
        Path filePath = Files.writeString(newFile, "Sample text"); // new method
        String fileContent = Files.readString(filePath); // new method
        System.out.println(fileContent);
    }

}