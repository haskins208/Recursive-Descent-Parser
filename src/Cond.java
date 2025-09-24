public class Cond {
    private Tokenizer tokenizer;
    private Comp comp;
    private Cond cond1;
    private Cond cond2;
    private int num;

    public Cond() {
        tokenizer = Tokenizer.getTokenizer();
    }

    public void parseCond() {
        if (tokenizer.getToken() == 15){
            num = 2;
            tokenizer.skipToken();
            cond1 = new Cond();
            cond1.parseCond();
        } else if(tokenizer.getToken() == 16){
            tokenizer.skipToken();
            cond1 = new Cond();
            cond1.parseCond();
            tokenizer.skipToken();
            if (tokenizer.getToken() == 18 ) {
                num = 3;
            } else {
                num = 4;
            }
            tokenizer.skipToken();
            cond2 = new Cond();
            cond2.parseCond();
            tokenizer.skipToken();
        } else {
            num = 1;
            comp = new Comp();
            comp.parseComp();
        }
    }

    public void printCond() {
        switch (num) {
            case 1:
                comp.printComp();
                break;
            case 2:
                System.out.print("!");
                cond1.printCond();
                break;
            case 3:
                System.out.print("[");
                cond1.printCond();
                System.out.print(" && ");
                cond2.printCond();
                System.out.print("]");
                break;
            case 4:
                System.out.print("[");
                cond1.printCond();
                System.out.print(" || ");
                cond2.printCond();
                System.out.print("]");
                break;
        }

    }

    public boolean evalCond() {
        switch (num) {
            case 1:
                return comp.evalComp();
            case 2:
                return !cond1.evalCond();
            case 3:
                return cond1.evalCond() && cond2.evalCond();
            case 4:
                return cond1.evalCond() || cond2.evalCond();
        }
        return false;
    }

}
