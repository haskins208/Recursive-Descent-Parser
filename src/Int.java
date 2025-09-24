import java.util.ArrayList;
import java.util.List;

public class Int {
    private Tokenizer tokenizer;
    private List<Integer> intList;
    private int num;

    public Int() {
        tokenizer = Tokenizer.getTokenizer();
        intList = new ArrayList<Integer>();
    }

    public void parseInt() {
        if (tokenizer.getToken() == 31) {
            if (tokenizer.intVal() < 0) {
                System.out.println("Error: Negative integer " + tokenizer.intVal() + " is not allowed");
                System.exit(0);
            }   
            intList.add(tokenizer.intVal());
            tokenizer.skipToken();
        } else {
            System.out.println("Error: Expected integer but found " + tokenizer.getToken());
            System.exit(0);
        }
    }

    public void printInt() {
        for (int num : intList) {
            System.out.print(num);
        }
    }

    public int execInt() {
        for (int num : intList) {
            return num;
        }
        return 0;
    }

}
