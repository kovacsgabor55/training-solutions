package ioreader.states;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {
    private List<State> states;

    public List<State> getStates() {
        return new ArrayList<>(states);
    }

    public StateRegister() {
        this.states = new ArrayList<>(50);
    }

    public void readStatesFromFile(String stringFileName) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + stringFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = br.readLine().split("-");
                states.add(new State(data[0], data[1]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!", e);
        }
    }

    public String findCapitalByStateName(String stateName) {
        for (State item : states) {
            if (item.getStateName().equals(stateName)) {
                return item.getCapital();
            }
        }
        throw new IllegalArgumentException("No state with this name!");
    }
}
