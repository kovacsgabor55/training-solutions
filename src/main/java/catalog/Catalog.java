package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    protected List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem1) {
        catalogItems.add(catalogItem1);
    }

    public void deleteItemByRegistrationNumber(String s) {
        CatalogItem delete = null;
        for (CatalogItem item : catalogItems) {
            if (item.getRegistrationNumber().equals(s)) {
                delete = item;
            }
        }
        catalogItems.remove(delete);
    }

    //FIXME
    public List<CatalogItem> getAudioLibraryItems() {
        return null;
    }

    //FIXME
    public List<CatalogItem> getPrintedLibraryItems() {
        return null;
    }

    //FIXME
    public int getAllPageNumber() {
        return 0;
    }

    //FIXME
    public int getFullLength() {
        return 0;
    }

    //FIXME
    public double averagePageNumberOver(int i) {
        return 0;
    }

    //FIXME
    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        return null;
    }
}
