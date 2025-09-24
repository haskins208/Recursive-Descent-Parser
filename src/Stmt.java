public class Stmt {
    private Tokenizer tokenizer;
    private Assign assign;
    private If ifStmt;
    private Loop loop;
    private In in;
    private Out out;
    private int num;

    public Stmt() {
        tokenizer = Tokenizer.getTokenizer();
        num = 0;
    }

    public void parseStmt() {
        int tokenNum = tokenizer.getToken();
        switch (tokenNum) {
            case 32: // "assign"
                assign = new Assign();
                assign.parseAssign();
                num = 1;
                break;
            case 5: // "if"
                ifStmt = new If();
                ifStmt.parseIf();
                num = 2;
                break;
            case 8: // "loop"
                loop = new Loop();
                loop.parseLoop();
                num = 3;
                break;
            case 10: // "in"
                in = new In();
                in.parseIn();
                num = 4;
                break;
            case 11: // "out"
                out = new Out();
                out.parseOut();
                num = 5;
                break;
        }
    }

    public void printStmt() {
        switch (num) {
            case 1:
                assign.printAssign();
                break;
            case 2:
                ifStmt.printIf();
                break;
            case 3:
                loop.printLoop();
                break;
            case 4:
                in.printIn();
                break;
            case 5:
                out.printOut();
                break;
        }
    }


    public void execStmt() {
        switch (num) {
            case 1:
                assign.execAssign();
                break;
            case 2:
                ifStmt.execIf();
                break;
            case 3:
                loop.execLoop();
                break;
            case 4:
                in.execIn();
                break;
            case 5:
                out.execOut();
                break;
        }
    }

}
