import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + ", " + age;
    }
}

class NameStreams {
    public static void main(String[] args) {
        List<String> names = List.of("Maria", "Ana");
        List<Person> people = new ArrayList<Person>();

        people.add(new Person("Olivia", 12));
        people.add(new Person("Gabriela", 32));

        Stream<String> namesStream = names.stream().map((String name) -> String.format("<li>%s</li>", name));
        Stream<String> peopleStream = people.stream().map((Person person) -> String.format("<li>%s</li>", person.getName()));
        List<String> allNames = Stream.concat(namesStream, peopleStream).collect(Collectors.toList());

        allNames.forEach(name -> System.out.println(name));

        List<Person> people2 = new ArrayList<Person>();

        allNames.forEach((String name) -> {
            people2.add(new Person(name, new Random().nextInt(1, 26)));
        });

        System.out.println("\nPeople over 18 years of age:");

        people2.forEach((Person person) -> {
            if (person.getAge() >= 18) {
                System.out.println(String.format("\t[%s, %d]", person.getName(), person.getAge()));
            }
        });
    }
}
