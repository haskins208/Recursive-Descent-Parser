import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Id {
    private Tokenizer tokenizer;
    public String name;
    static Map<String, Id> ids = new HashMap<>();
    static int idCount = 0;
    public boolean declared;
    public boolean initialized;
    private int value;
    static boolean checkDup = false;
    static boolean checkDecl = false;
    static boolean checkInit = false;

    public Id() {
        declared = false;
        initialized = false;
        tokenizer = Tokenizer.getTokenizer();
        name = tokenizer.idName();
    }

    public void parseId() {
        if (checkDup) {
                if (ids.containsKey(name)) {
                    System.out.println("Error: variable " + name + " already declared");
                    System.exit(1);
                }
        }
        if (checkDecl) {
            if (ids.containsKey(name)) {
                declared = true;
            }
            if (!declared) {
                System.out.println("Error: variable " + name + " not declared");
                System.exit(1);
            }
        }
        if (!declared) {
            ids.put(name, this);
            declared = true;
            idCount++;
            
        }
        tokenizer.skipToken();
    }

    public int getIdVal() {
        if (!initialized) {
            System.out.println("Error: variable " + name + " not initialized");
            System.exit(1);
        }
        return value;
    }

    public void setIdVal(int val) {
        value = val;
        initialized = true;
    }
        
    public void printId() {
        System.out.print(name);

    }

    public String execId() {
        if (checkInit) {
            if (!initialized) {
                System.out.println("Error: variable " + name + " not initialized");
                System.exit(1);
            }
        }
        return name;
    }

}
