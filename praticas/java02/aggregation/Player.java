package aggregation;

public class Player {
    private String name;
    private int number;
    private int goals;

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }

    public int getGoals() {
        return this.goals;
    }

    public Player(String name, int number, int goals) {
        this.name = name;
        this.number = number;
        this.goals = goals;
    }

    public void show() {
        System.out.println(this.name + ", " + "number " + this.number + ", " + this.goals + " goals.");
    }
}
