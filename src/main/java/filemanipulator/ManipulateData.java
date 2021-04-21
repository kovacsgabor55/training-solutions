package filemanipulator;

import java.util.ArrayList;
import java.util.List;

public class ManipulateData {
    private int skipFirst;
    private List<String> firstPutLineList = new ArrayList<>();
    private List<String> deleteLineList = new ArrayList<>();
    private List<String> replaceInLineList = new ArrayList<>();
    private List<String> replaceOutLineList = new ArrayList<>();
    private List<String> lastPutLineList = new ArrayList<>();
    private int skipLast;
    private String activator;
    private boolean isActivator = false;
    private String deActivator;
    private boolean isDeActivator = false;
    private boolean isActive;

    //region setter
    public void setSkipFirst(int skipFirst) {
        this.skipFirst = skipFirst;
    }

    public void setFirstPutLineList(List<String> firstPutLineList) {
        this.firstPutLineList = firstPutLineList;
    }

    public void setDeleteLineList(List<String> deleteLineList) {
        this.deleteLineList = deleteLineList;
    }

    public void setReplaceInLineList(List<String> replaceInLineList) {
        this.replaceInLineList = replaceInLineList;
    }

    public void setReplaceOutLineList(List<String> replaceOutLineList) {
        this.replaceOutLineList = replaceOutLineList;
    }

    public void setLastPutLineList(List<String> lastPutLineList) {
        this.lastPutLineList = lastPutLineList;
    }

    public void setSkipLast(int skipLast) {
        this.skipLast = skipLast;
    }

    public void setActivator(String activator) {
        this.activator = activator;
        this.isActivator = true;
    }

    public void setDeActivator(String deActivator) {
        this.deActivator = deActivator;
        this.isDeActivator = true;
    }
    //endregion

    //region adder
    public void addFistPut(String line) {
        firstPutLineList.add(line);
    }

    public void addDelete(String line) {
        deleteLineList.add(line);
    }

    public void addReplace(String in, String out) {
        replaceInLineList.add(in);
        replaceOutLineList.add(out);
    }

    public void addLastPut(String line) {
        lastPutLineList.add(line);
    }
    //endregion

    public void SpiltUpdate(String input) {
        String[] data = input.split("■");
        replaceInLineList.add(data[0]);
        replaceOutLineList.add(data[1]);
    }

    public List<String> worker(List<String> inputList) {
        List<String> workingList = new ArrayList<>(inputList);
        //TODO no checked index

        return workingList;
    }

    private List<String> activateCopy(List<String> inputList) {
        List<String> result = new ArrayList<>();
        for (String item : inputList) {
            if (activateDeactivate(item, ActivatorStatus.ACTIVATE)) {
                result.add(item);
            }
        }
        return result;
    }

    private List<String> replace(List<String> inputList) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < replaceInLineList.size() && i < replaceOutLineList.size(); i++) {
            for (String item : inputList) {
                item.replace(replaceInLineList.get(i), replaceOutLineList.get(i));
            }
        }
        return result;
    }

    private List<String> delete(List<String> inputList) {
        List<String> result = new ArrayList<>();
        for (String deleteItem : deleteLineList) {
            for (String item : inputList) {
                if (!item.contains(deleteItem)) {
                    result.add(item);
                }
            }
        }
        return result;
    }

    /**
     * ahonnan mar masoljon és ahonnan mar ne masoljon aktuais sor
     *
     * @param input
     * @param status
     * @return
     */
    private boolean activateDeactivate(String input, ActivatorStatus status) {
        if (status == ActivatorStatus.ACTIVATE) {
            if (isActive) {
                return true;
            } else {
                if (input.contains(activator)) {
                    isActive = true;
                    return true;
                }
            }
        }
        if (status == ActivatorStatus.DEACTIVATE) {
            if (input.contains(deActivator)) {
                isActive = false;
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException(":(");
    }

}
