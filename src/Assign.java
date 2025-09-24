public class Assign {
    private Tokenizer tokenizer;
    private Id id;
    private Exp exp;

    public Assign() {
        tokenizer = Tokenizer.getTokenizer();
    }

    public void parseAssign() {
        String idName = tokenizer.idName();
        if (!Id.ids.containsKey(idName)) {
            System.out.println("Error: variable " + idName + " not declared");
            System.exit(1);
        }
        id = Id.ids.get(idName);
        tokenizer.skipToken();
        if (tokenizer.getToken() != 14) {
            System.out.println("Error: = expected in assignment statement");
            System.exit(1);
        }
        tokenizer.skipToken();
        exp = new Exp();
        exp.parseExp();
        if (tokenizer.getToken() != 12) {
            System.out.println(id.name);
            System.out.println("Error: ; expected in assignment statement");
            System.exit(1);
        }
        tokenizer.skipToken();
    }

    public void printAssign() {
        for (int i = 0; i < StmtSeq.indent; i++) {
            System.out.print("    ");
        }
        id.printId();
        System.out.print(" = ");
        exp.printExp();
        System.out.println(";");
    }

    public void execAssign() {
        id.initialized = true;
        id.setIdVal(exp.execExp());
    }

}
