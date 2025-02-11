package polymorphism;

import java.util.ArrayList;

public class GameItemTestCLI {
    public static void main(String[] args) {
        ArrayList<GameItem> bag = new ArrayList<GameItem>();

        // Thanks to inheritance and polymorphism, we can add
        // Weapon and Consumable objects in ArrayList<GameItem>
        bag.add(new Weapon("Sword", 3, true));
        bag.add(new Weapon("Rock", 1, false));
        bag.add(new Consumable("Potion", 0.5, "restore health"));
        bag.add(new Consumable("Food", 1.5, "sate hunger"));

        // 3 ways to iterate over the ArrayList

        // 1) Don't do this: C-like iteration over the ArrayList
        for (int i = 0; i < bag.size(); i++) {
            System.out.println(bag.get(i));
        }
        // 2) Since Java 5, enhanced for-loop
        // See: https://www.programiz.com/java-programming/enhanced-for-loop
        for (GameItem item : bag) {
            System.out.println(item);
        }
        // 3) Since Java 8, forEach method (based on functional programming!)
        // See: https://www.baeldung.com/foreach-java
        bag.forEach(item -> { // this is a lambda expression
            System.out.println(item);
        });

        // Iterate over the ArrayList and process only Consumable objects
        // Use instanceof to check whether an object is an instance of the Consumable
        // class
        for (GameItem item : bag) {
            if (item instanceof Consumable) {
                /// Como nós estamos tratando `item` como sendo um `GameItem`, ele
                /// não possui o método `consume`, por isso nós devemos fazer o downcasting
                /// de GameItem para Consumable.
                // item.consume(); // compilation error
                Consumable c = (Consumable) item; // compilation ok
                c.consume();
                System.out.println(c);
            }
            ;
        }

        double totalWeight = 0;

        for (GameItem item : bag) {
            totalWeight += item.getWeight();
        }

        System.out.println("\nTotal weight: " + totalWeight);
    }
}
