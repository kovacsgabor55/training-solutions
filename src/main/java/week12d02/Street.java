package week12d02;

import java.util.ArrayList;
import java.util.List;

public class Street {

    private int odd = -1;
    private int even = 0;

    private final List<Site> sites = new ArrayList<>();

    public void sellSite(Site site) {
        if (site.getSide() == Side.EVEN_SIDE) {
            even += 2;
            site.setHouseNumber(even);
        } else {
            odd += 2;
            site.setHouseNumber(odd);
        }
        sites.add(site);
    }

    public List<Site> getSites() {
        return new ArrayList<>(sites);
    }

    public int lastSiteHouseNumber() {
        int last = sites.size() - 1;
        return sites.get(last).getHouseNumber();
    }

    public List<ReportFence> report() {
        List<ReportFence> result = new ArrayList<>();
        int[] counter = new int[Fence.values().length];
        for (Site item : sites) {
            counter[item.getFence().getValue()]++;
        }
        for (Fence item : Fence.values()) {
            result.add(new ReportFence(item, counter[item.getValue()]));
        }
        return result;
    }
}