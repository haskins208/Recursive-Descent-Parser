import java.util.ArrayList;
import java.util.List;

public class Exp {
    private Tokenizer tokenizer;
    private Fac fac;
    private String operator;
    private Exp exp;


    public Exp() {
        tokenizer = Tokenizer.getTokenizer();
    }

    public void parseExp() {
        fac = new Fac();
        fac.parseFac();
        while (tokenizer.getToken() == 22 || tokenizer.getToken() == 23) {
            if (tokenizer.getToken() == 22) {
                operator = "+";
            } else {
                operator = "-";
            }
            tokenizer.skipToken();
            exp = new Exp();
            exp.parseExp();
        }
    }

    public void printExp() {
        fac.printFac();
        if (operator != null && exp != null) {
            System.out.print(" " + operator + " ");
            exp.printExp();
        }
    }

    public int execExp() {
        int result = fac.execFac();
        if (operator != null && exp != null) {
            if (operator.equals("+")) {
                result += exp.execExp();
            } else {
                result -= exp.execExp();
            }
        }
        return result;
    }

}
