public class Person {


    private String name;
    private int age;
    public Boolean cool;





    public Person (String inputName, int inputAge, Boolean cool) {
        this.name = inputName;
        this.age = inputAge;
        this.cool = cool;
    }






    public String setName(String inputName) {
        this.name = inputName;
        return this.name;
    }

    public String getName() {
        return this.name;
    }

     public int setAge(int inputAge) {
        this.age = inputAge;
        return this.age;
    }

    public int getAge() {
        return this.age;
    }

    public void makeCool(Boolean embarrassing) {
        if (embarrassing == true){
            this.cool = false;
        } else {
            this.cool = true;
        }
    }

}


