package CricBuzz.Match;

public class Umpire extends Person{
    Role role;

    public Umpire(int id, String name, int age, String country, String sex) {
        super(id, name, age, country, sex);
        this.role = Role.UMPIRE;
    }
}
