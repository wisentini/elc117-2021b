import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


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

class PersonComparatorLambda {

	public static void main(String[] args) {
		List<Person> crowd = new ArrayList<Person>();
		crowd.add(new Person("Maria", 42));
		crowd.add(new Person("Ana", 32));
		crowd.add(new Person("Gabriela", 16));
    
    crowd.sort(new Comparator<Person>() {
    	@Override
      public int compare(Person p1, Person p2) {
      	return p1.getName().compareTo(p2.getName());
      }
    });
		for (Person p : crowd) {
			System.out.println(p);
		}
	}


}

