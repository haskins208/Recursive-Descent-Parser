public class Decl {
    private Tokenizer tokenizer;
    private IdList idList;

    public Decl() {
        tokenizer = Tokenizer.getTokenizer();
    }

    public void parseDecl() {
        if (tokenizer.getToken() != 4) {
            System.out.println("Invalid token, 'Int' expected");
            System.exit(1);
        }
        tokenizer.skipToken();
        idList = new IdList();
        idList.parseIdList();
        if (tokenizer.getToken() != 12) {
            System.out.println("Invalid token, ';' expected");
            System.out.println(tokenizer.getToken());
            System.exit(1);
        }
    }

    public void printDecl() {
        System.out.print("    int ");
        idList.printIdList();
        System.out.println(";");
    }

    public void execDecl() {
        idList.execIdList();
    }

}
