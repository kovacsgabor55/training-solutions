package methoverloading.pub;

import java.util.List;

public class ListOfGoodPubs {
    List<Pub> goodPubs;

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs.isEmpty()) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.goodPubs = goodPubs;
    }

    public Pub findTheBest() {
        Pub best = goodPubs.get(0);
        for (Pub item : goodPubs) {
            if (item.getTime().isEarlier(best.getTime())) {
                best = item;
            }
        }
        return best;
    }
}
