package association;

class Bank {
    private String name;

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class Association {
    public static void main(String[] args) {
        Bank bank = new Bank("Axis");
        Employee emp = new Employee("Neha");

        System.out.println(emp.getName() + " is employee of " + bank.getName());
    }
}
