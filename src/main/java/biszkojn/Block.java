package biszkojn;

import java.security.Timestamp;
import java.util.List;

public class Block {
    private int id;
    private int version;
    private int size;
    private Timestamp timestamp;
    private String merkleRoot;
    private String hash;
    private String previousBlockHash;
    private int transactionCount;
    private List<Transaction> transactionList;
}
