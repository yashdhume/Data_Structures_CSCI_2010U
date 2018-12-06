package Labs.Lab5;

public class Warrior implements Comparable<Warrior> {
    private String name;
    private int speed;
    private int strength;
    private int hp;

    public Warrior(String name, int speed, int str, int hp) {
        this.name = name;
        this.speed = speed;
        this.strength = str;
        this.hp = hp;
    }
    public String getName() { return this.name; }
    public int getSpeed() { return this.speed; }
    public void setSpeed(int a){this.speed = a;}
    public int getStrength() { return this.strength; }
    public int getHp() { return this.hp; }
    public String toString() { return this.name + "(" + this.speed + ")"; }
    @Override
    public int compareTo(Warrior t) { return this.speed - t.speed; }

}
