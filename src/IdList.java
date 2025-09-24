import java.util.List;
import java.util.ArrayList;

public class IdList {
    private Tokenizer tokenizer;
    private Id id;
    private List<Id> idList;
    public boolean isDecl;

    public IdList() {
        tokenizer = Tokenizer.getTokenizer();
        idList = new ArrayList<Id>();
    }

    public void parseIdList() {
        while (tokenizer.getToken() != 12) {
            id = new Id();
            id.parseId();
            idList.add(id);
            if (tokenizer.getToken() == 13) {
                tokenizer.skipToken();
            }
        }
    }

    public void printIdList() {
        for (Id id : idList) {
            id.printId();
            if (idList.indexOf(id) != idList.size() - 1) {
                System.out.print(", ");
            }
        }

    }

    public List<Id> execIdList() {
        for (Id id : idList) {
            Id id1 = Id.ids.get(id.name);
            if (isDecl) {
                id1.initialized = true;
            }
            id1.execId();
        }
        return idList;
    }

}
