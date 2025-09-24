public class CompOp {
    private Tokenizer tokenizer;
    private String compOp;
    private int num;
    private CompOp compOp1;

    public CompOp() {
        tokenizer = Tokenizer.getTokenizer();
    }

    public void parseCompOp() {
        int tokenNum = tokenizer.getToken();
        compOp1 = new CompOp();
        switch (tokenNum) {
            case 25:
                compOp = "!=";
                num = 1;
                tokenizer.skipToken();
                break;
            case 26:
                compOp = "==";
                num = 2;
                tokenizer.skipToken();
                break;
            case 27:
                compOp = "<";
                num = 3;
                tokenizer.skipToken();
                break;
            case 28:
                compOp = ">";
                num = 4;
                tokenizer.skipToken();
                break;
            case 29:
                compOp = "<=";
                num = 5;
                tokenizer.skipToken();
                break;
            case 30:
                compOp = ">=";
                num = 6;
                tokenizer.skipToken();
                break;
        }
    }

    public void printCompOp() {
        switch(num){
            case 1: 
                System.out.print(" != ");
                break;
            case 2:
                System.out.print(" == ");
                break;
            case 3:
                System.out.print(" < ");
                break;
            case 4:
                System.out.print(" > ");
                break;
            case 5:
                System.out.print(" <= ");
                break;
            case 6:
                System.out.print(" >= ");
                break;
        }
    }

    public int execCompOp() {
        return num;
    }

}
