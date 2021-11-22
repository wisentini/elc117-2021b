package polymorphism;

public class Consumable extends GameItem {
    private String useTo;
    private boolean consumed;

    public Consumable(String name, double weight, String useTo) {
        super(name, weight);
        this.useTo = useTo;
        this.consumed = false;
    }

    public void consume() {
        this.consumed = true;
        this.resetWeight();
    }

    public boolean isConsumed() {
        return this.consumed;
    }

    public String toString() {
        return super.toString() + ", Use to: " + this.useTo + ", Consumed: " + this.consumed;
    }
}
