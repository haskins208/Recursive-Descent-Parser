public class Loop {
    private Tokenizer tokenizer;
    private Cond cond;
    private StmtSeq stmtSeq;

    public Loop() {
        tokenizer = Tokenizer.getTokenizer();
    }

    public void parseLoop() {
        tokenizer.skipToken();
        cond = new Cond();
        cond.parseCond();
        tokenizer.skipToken();
        stmtSeq = new StmtSeq();
        stmtSeq.parseStmtSeq();
        tokenizer.skipToken();
        tokenizer.skipToken();
    }

    public void printLoop() {
        for (int i = 0; i < StmtSeq.indent; i++) {
            System.out.print("    ");
        }
        System.out.print("while ");
        cond.printCond();
        System.out.println(" loop");
        StmtSeq.indent++;
        stmtSeq.printStmtSeq();
        StmtSeq.indent--;
        for (int i = 0; i < StmtSeq.indent; i++) {
            System.out.print("    ");
        }
        System.out.println("end;");
    }

    public void execLoop() {
        while (cond.evalCond()) {
            stmtSeq.execStmtSeq();
        }
    }

}
