public class Prog {
    private Tokenizer tokenizer;
    private DeclSeq declSeq;
    private StmtSeq stmtSeq;

    public Prog() {
       this.tokenizer = Tokenizer.getTokenizer();
    }

    public void parseProg() {
        if (tokenizer.getToken() != 1) {
            System.out.println("Invalid token, 'Program' expected");
            System.exit(1);
        }
        tokenizer.skipToken();
        declSeq = new DeclSeq();
        declSeq.parseDeclSeq();
        if (tokenizer.getToken() != 2) {
            System.out.println("Invalid token, 'Begin' expected");
            System.exit(1);
        }
        tokenizer.skipToken();
        stmtSeq = new StmtSeq();
        stmtSeq.parseStmtSeq();
        if (tokenizer.getToken() != 3) {
            System.out.println("Invalid token, 'End' expected");
            System.exit(1);
        }
        tokenizer.skipToken();
        if (tokenizer.getToken() != 33) {
            System.out.println("Invalid token, 'EOF' expected");
            System.exit(1);
        }
    }

    public void printProg() {
        System.out.println("program ");
        declSeq.printDeclSeq();
        System.out.println("begin");
        stmtSeq.printStmtSeq();
        System.out.println("end");
        System.out.println("");
    }

    public void execProg() {
        declSeq.execDeclSeq();
        stmtSeq.execStmtSeq();
    }
}
