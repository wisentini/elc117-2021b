import java.util.List;
import java.util.Arrays;
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
		List<String> names = List.of("Maria","Ana");

		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Olivia", 12));
		people.add(new Person("Gabriela", 32));
	}

}
