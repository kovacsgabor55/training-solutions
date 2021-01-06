package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {
    private final String name;
    private final List<Skill> skills;

    public Cv(String name) {
        this.name = name;
        skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return new ArrayList<>(skills);
    }

    public void addSkills(String... skills) {
        for (String item : skills) {
            String[] temp = item.split(" \\(");
            this.skills.add(new Skill(temp[0], Integer.parseInt(temp[1].replace(")", ""))));

        }
    }

    public int findSkillLevelByName(String skillName) {
        for (Skill item : skills) {
            if (item.getName().equals(skillName)) {
                return item.getLevel();
            }
        }
        throw new SkillNotFoundException(null);
    }
}
