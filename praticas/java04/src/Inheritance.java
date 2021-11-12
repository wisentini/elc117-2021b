import java.util.ArrayList;

class Person {
    // private String name;
    protected String name;

    public Person() {
        System.out.println("\nConstrutor de Person");
        name = "Fulano";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Student extends Person {
    private String course;

    public Student() {
        System.out.println("\nConstrutor de Student");
        course = "CC";
    }

    public boolean checkName(char c) {
        // return this.getName().toCharArray()[0] == c;
        return name.toCharArray()[0] == c;
    }      
}

class PhdStudent extends Student {
    private String theses;

    public PhdStudent() {
        System.out.println("\nConstrutor de PhDStudent");
        theses = "Something important goes here...";
    }
}

class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Student student = new Student();
        PhdStudent phdStudent = new PhdStudent();
        ArrayList<Person> list = new ArrayList<Person>();

        list.add(person);
        list.add(student);
        list.add(phdStudent);

        student.setName("Beltrano");

        for (Person ref : list) {
            System.out.println("\n" + ref.getName());
        }

        System.out.println("\n" + student.checkName('B'));

        for (Person ref : list) {
            if (ref.equals(phdStudent)) {
                System.out.println("\nPhD student spotted!\n");
            }
        }

        /* Por mais que phdStudent e ps possuam seus atributos inicializados
         * com o mesmo conteúdo, phdStudent.equals(ps) não retorna true, porque
         * eles não representam o mesmo objeto. Vamos testar se isso é verdade:
         */
        PhdStudent ps = new PhdStudent();

        System.out.println("\nphdStudent is equal to ps? " + phdStudent.equals(ps) + "\n");

        for (Person ref : list) {
            System.out.println("\n" + ref.getClass());
        }
    }
}
