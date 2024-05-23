import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Player {
    private String name;
    private int age;
    private String position;
    private Map<String, Integer> skills;

    public Player(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position.toLowerCase();
        this.skills = new HashMap<>();
//        initializeSkills();
    }

//    private void initializeSkills() {
//        String[] skillSet;
//        switch (position.toLowerCase()) {
//            case "goalkeeper":
//                skillSet = new String[]{"GK jumping", "GK catching", "GK positioning", "GK reflexes", "short passing", "long passing"};
//                break;
//            case "defender":
//                skillSet = new String[]{"positioning", "physical", "speed", "short passing", "long passing", "heading"};
//                break;
//            case "midfielder":
//                skillSet = new String[]{"positioning", "physical", "speed", "short passing", "long passing", "shooting"};
//                break;
//            case "attacker":
//                skillSet = new String[]{"positioning", "physical", "speed", "shooting", "short passing", "agility", "heading"};
//                break;
//            default:
//                System.out.println("Invalid position" + position);
//                break;
//        }
//        Random rand = new Random();
//        for (String skill : skillSet) {
//            skills.put(skill, rand.nextInt(100) + 1);
//        }
//    }

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
}