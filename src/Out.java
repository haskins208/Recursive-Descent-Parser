import java.util.List;

public class Out {

    private Tokenizer tokenizer;
    private IdList idList;

    public Out() {
        tokenizer = Tokenizer.getTokenizer();
    }

    public void parseOut() {
        tokenizer.skipToken();
        idList = new IdList();
        idList.parseIdList();
        tokenizer.skipToken();
    }

    public void printOut() {
        for (int i = 0; i < StmtSeq.indent; i++) {
            System.out.print("    ");
        }
        System.out.print("write ");
        idList.printIdList();
        System.out.println(";");
    }

    public void execOut() {
        List<Id> ids = idList.execIdList();
        for (Id id : ids) {
            Id id1 = Id.ids.get(id.name);
            System.out.println(id.name + " = " + id1.getIdVal() + " ");
        }
        System.out.println();
    }

}
