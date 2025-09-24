public class Fac {
    private Tokenizer tokenizer;
    private Op op;
    private Fac fac;

    public Fac() {
        tokenizer = Tokenizer.getTokenizer();
    }

    public void parseFac() {
        op = new Op();
        op.parseOp();
        if (tokenizer.getToken() == 24) {
            tokenizer.skipToken();
            fac = new Fac();
            fac.parseFac();
        }
    }

    public void printFac() {
        op.printOp();
        if (fac != null) {
            System.out.print(" * ");
            fac.printFac();
        }
    }

    public int execFac() {
        int result = op.execOp();
        if (fac != null) {
            result *= fac.execFac();
        }
        return result;
    }

}
