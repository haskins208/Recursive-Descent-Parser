import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Buffer {
    private static Buffer instance;
    private BufferedReader bufferedReader;

    private Buffer(String inputFile) {
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
        } catch (IOException e) {
            System.out.println("Error: Unable to open input file");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void initialize(String inputFile) {
        if (instance == null) {
            instance = new Buffer(inputFile);
        }
    }

    public static Buffer getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Buffer not initialized. Call initialize() first.");
        }
        return instance;
    }

    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }

    public void close() throws IOException {
        bufferedReader.close();
    }

}
