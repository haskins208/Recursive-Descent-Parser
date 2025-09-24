import java.io.IOException;
import java.util.List;

public class In {
    private Tokenizer tokenizer;
    private IdList idList;

    public In() {
        tokenizer = Tokenizer.getTokenizer();
    }

    public void parseIn() {
        tokenizer.skipToken();
        idList = new IdList();
        idList.parseIdList();
        tokenizer.skipToken();
    }

    public void printIn() {
        for (int i = 0; i < StmtSeq.indent; i++) {
            System.out.print("    ");
        }
        System.out.print("read ");
        idList.printIdList();
        System.out.println(";");
    }

    public void execIn() {
        idList.isDecl = true;
        List<Id> ids = idList.execIdList();
        Buffer buffer = Buffer.getInstance();
        try {
            String line;
            for (Id id : ids) {
                Id id1 = Id.ids.get(id.name);
                id1.initialized = true;
                if ((line = buffer.readLine()) != null) {
                    int value = Integer.parseInt(line.trim());
                    id1.setIdVal(value);
                } else {
                    System.out.println("Error: Not enough input values for read statement");
                    System.exit(1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to read input file");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
