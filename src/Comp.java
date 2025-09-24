public class Comp {
    private Tokenizer tokenizer;
    private CompOp compOp;
    private Op op1;
    private Op op2;

    public Comp() {
        tokenizer = Tokenizer.getTokenizer();
    }

    public void parseComp() {
        tokenizer.skipToken();
        op1 = new Op();
        op1.parseOp();
        compOp = new CompOp();
        compOp.parseCompOp();
        op2 = new Op();
        op2.parseOp();
        tokenizer.skipToken();
    }

    public void printComp() {
        System.out.print("(");
        op1.printOp();
        compOp.printCompOp();
        op2.printOp();
        System.out.print(")");
    }

    public boolean evalComp() {
        int value1 = op1.execOp();
        int comp = compOp.execCompOp();
        int value2 = op2.execOp();

        switch (comp) {
            case 1:
                return value1 != value2;
            case 2:
                return value1 == value2;
            case 3:
                return value1 < value2;
            case 4:
                return value1 > value2;
            case 5:
                return value1 <= value2;
            case 6:
                return value1 >= value2;
        }
        return false;
    }

}
