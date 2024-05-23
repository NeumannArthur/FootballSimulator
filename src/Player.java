import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private int age;
    private String position;
    private Map<String, Integer> skills;
    private Team currentTeam;

    public Player(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position.toLowerCase();
        this.skills = new HashMap<>();
        this.currentTeam = null;
        initializeSkills();
    }

    private void initializeSkills() {
        String[] skillSet = new String[]{};
        switch (position.toLowerCase()) {
            case "goalkeeper":
                skillSet = new String[]{"GK jumping", "GK catching", "GK positioning", "GK reflexes", "short passing", "long passing"};
                break;
            case "defender":
                skillSet = new String[]{"positioning", "physical", "speed", "short passing", "long passing", "heading"};
                break;
            case "midfielder":
                skillSet = new String[]{"positioning", "physical", "speed", "short passing", "long passing", "shooting"};
                break;
            case "attacker":
                skillSet = new String[]{"positioning", "physical", "speed", "shooting", "short passing", "agility", "heading"};
                break;
            default:
                System.out.println("Invalid position" + position);
                break;
        }

        for (String skill : skillSet) {
            skills.put(skill, 0);
        }
    }

    //getter and setter methods
    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }


    public String getPosition() {
        return this.position;
    }

    public void setPosition(String newPosition) {
        this.position = newPosition;
    }

    public Map<String, Integer> getSkills() {
        return this.skills;
    }

    public int getSkill(String skill) {
        if (skills.containsKey(skill)) {
            return skills.get(skill);
        } else {
            System.out.println("Does this skill exist?");
        }
        return skills.get(skill);
    }

    public void setSkill(String skill, int value) {
        if (skills.containsKey(skill)) {
            if (value >= 0 && value <= 100) {
                skills.put(skill, value);
            } else {
                System.out.println("Skill value between 0 and 100!");
            }
        } else {
            System.out.println("Skill not found for this poisition!");
        }
    }

    public void transferTeam(Team newTeam) {
        this.currentTeam = newTeam;
    }

    public Team getCurrentTeam() {
        if (this.currentTeam == null) {
            return (new Team("Free Agent", "Player's country"));
        }
        return this.currentTeam;
    }
}