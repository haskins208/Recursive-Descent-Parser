import java.util.ArrayList;
import java.util.List;

public class DeclSeq {
    private Tokenizer tokenizer;
    private Decl decl;
    private List<Decl> declList;

    public DeclSeq() {
        tokenizer = Tokenizer.getTokenizer();
        declList = new ArrayList<Decl>();
    }

    public void parseDeclSeq() {
        Id.checkDup = true;
        if (tokenizer.getToken() != 4) {
            System.out.println("Invalid token, 'Int' expected");
            System.exit(1);
        }
        while (tokenizer.getToken() == 4) {
            decl = new Decl();
            decl.parseDecl();
            declList.add(decl);
            tokenizer.skipToken();
        }
        Id.checkDup = false;
    }

    public void printDeclSeq() {
        for (Decl decl : declList) {
            decl.printDecl();
        }
    }

    public void execDeclSeq() {
        for (Decl decl : declList) {
            decl.execDecl();
        }
    }
}
