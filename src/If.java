public class If {
    private Tokenizer tokenizer;
    private Cond cond;
    private StmtSeq stmtSeq1;
    private StmtSeq stmtSeq2;
    private int num = 0;

    public If() {
        tokenizer = Tokenizer.getTokenizer();
    }

    public void parseIf() {
        tokenizer.skipToken();
        cond = new Cond();
        cond.parseCond();
        tokenizer.skipToken();
        stmtSeq1 = new StmtSeq();
        stmtSeq1.parseStmtSeq();
        if (tokenizer.getToken() == 7) {
            num = 2;
            tokenizer.skipToken();
            stmtSeq2 = new StmtSeq();
            stmtSeq2.parseStmtSeq();
            tokenizer.skipToken();
            tokenizer.skipToken();
        } else {
            num = 1;
            stmtSeq2 = null;
        }
    }

    public void printIf() {
        for (int i = 0; i < StmtSeq.indent; i++) {
            System.out.print("    ");
        }
        System.out.print("if ");
        cond.printCond();
        System.out.println(" then");
        StmtSeq.indent++;
        stmtSeq1.printStmtSeq();
        StmtSeq.indent--;
        if (num == 2) {
            for (int i = 0; i < StmtSeq.indent; i++) {
                System.out.print("    ");
            }
            System.out.println("else");
            StmtSeq.indent++;
            stmtSeq2.printStmtSeq();
            StmtSeq.indent--;
        }
        for (int i = 0; i < StmtSeq.indent; i++) {
            System.out.print("    ");
        }
        System.out.println("end;");

    }

    public void execIf() {
        if (cond.evalCond()) {
            stmtSeq1.execStmtSeq();
        } else if (num == 2) {
            stmtSeq2.execStmtSeq();
        }
    }

}
