import java.util.List; 
import java.util.ArrayList;

public class StmtSeq {
    private Tokenizer tokenizer;
    private Stmt stmt;
    private List<Stmt> stmtList;
    static int indent = 1;

    public StmtSeq() {
        tokenizer = Tokenizer.getTokenizer();
        stmtList = new ArrayList<Stmt>();
    }

    public void parseStmtSeq() {
        Id.checkDecl = true;
        while (tokenizer.getToken() != 3 && tokenizer.getToken() != 7) {
            stmt = new Stmt();
            stmt.parseStmt();
            stmtList.add(stmt);
        }
    }

    public void printStmtSeq() {
        for (Stmt stmt : stmtList) {
            stmt.printStmt();
        }
    }

    public void execStmtSeq() {
        Id.checkInit = true;
        for (Stmt stmt : stmtList) {
            stmt.execStmt();
        }
    }

}
