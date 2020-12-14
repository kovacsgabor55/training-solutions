package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    protected List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        CatalogItem delete = null;
        for (CatalogItem item : catalogItems) {
            if (item.getRegistrationNumber().equals(registrationNumber)) {
                delete = item;
            }
        }
        catalogItems.remove(delete);
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioLibraryItems = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasAudioFeature()) {
                audioLibraryItems.add(item);
            }
        }
        return audioLibraryItems;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedLibraryItems = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature()) {
                printedLibraryItems.add(item);
            }
        }
        return printedLibraryItems;
    }

    public int getAllPageNumber() {
        int allPageNumber = 0;
        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature()) {
                allPageNumber += item.numberOfPagesAtOneItem();
            }
        }
        return allPageNumber;
    }

    public int getFullLength() {
        int fullLenght = 0;
        for (CatalogItem item : catalogItems) {
            if (item.hasAudioFeature()) {
                fullLenght += item.fullLengthAtOneItem();
            }
        }
        return fullLenght;
    }

    public double averagePageNumberOver(int pageNumberOver) {
        double sum = 0;
        double counter = 0;
        if (pageNumberOver <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }
        for (CatalogItem item : catalogItems) {
            if (item.numberOfPagesAtOneItem() > pageNumberOver) {
                sum += item.numberOfPagesAtOneItem();
                counter++;
            }
        }
        if (counter == 0) {
            throw new IllegalArgumentException("No page");
        }
        return sum / counter;
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        if (searchCriteria.hasTitle() && searchCriteria.hasContributor()) {
            return findByCriteriaContributor(searchCriteria, findByCriteriaTitle(searchCriteria, catalogItems));
        }
        if (searchCriteria.hasTitle()) {
            return findByCriteriaTitle(searchCriteria, catalogItems);
        }
        if (searchCriteria.hasContributor()) {
            return findByCriteriaContributor(searchCriteria, catalogItems);
        }
        return new ArrayList<>();
    }

    private List<CatalogItem> findByCriteriaTitle(SearchCriteria searchCriteria, List<CatalogItem> catalogItems) {
        List<CatalogItem> searchedCatalogItems = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            for (String titleItem : item.getTitles()) {
                if (titleItem.equals(searchCriteria.getTitle())) {
                    searchedCatalogItems.add(item);
                }
            }
        }
        return searchedCatalogItems;
    }

    private List<CatalogItem> findByCriteriaContributor(SearchCriteria searchCriteria, List<CatalogItem> catalogItems) {
        List<CatalogItem> searchedCatalogItems = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            for (String contributorItem : item.getContributors()) {
                if (contributorItem.equals(searchCriteria.getContributor())) {
                    searchedCatalogItems.add(item);
                }
            }
        }
        return searchedCatalogItems;
    }

}
