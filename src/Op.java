public class Op {
    private Tokenizer tokenizer;
    private Int intVal;
    private Id id;
    private Exp exp;
    private int num = 0;
    private Op op;

    public Op() {
        tokenizer = Tokenizer.getTokenizer();
    }

    public void parseOp() {
        op = new Op();
        if (tokenizer.getToken() == 31) {
            intVal = new Int();
            intVal.parseInt();
            num = 1;
        } else if (tokenizer.getToken() == 32) {
            id = new Id();
            id.parseId();
            num = 2;
            if (!id.declared) {
                System.out.println("Error: variable " + id.name + " not declared");
                System.exit(0);
            }
        } else if (tokenizer.getToken() == 20) {
            tokenizer.skipToken();
            exp = new Exp();
            exp.parseExp();
            num = 3;
            tokenizer.skipToken();

        }
    }

    public void printOp() {
        switch (num) {
            case 1:
                intVal.printInt();
                break;
            case 2:
                id.printId();
                break;
            case 3:
                System.out.print("(");
                exp.printExp();
                System.out.print(")");
                break;
        }
    }

    public int execOp() {
        if (num == 1) {
            return intVal.execInt();
        } else if (num == 2) {
            id = Id.ids.get(id.name);
            return id.getIdVal();
        } else if (num == 3) {
            return exp.execExp();
        }
        return 0;
    }

}
