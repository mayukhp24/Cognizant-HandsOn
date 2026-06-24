class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return employeeId + " | " + name + " | " + position + " | Rs." + salary;
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void add(Employee e) {
        if (count == employees.length) {
            System.out.println("Storage full, cannot add " + e.name);
            return;
        }
        employees[count++] = e;
    }

    public Employee search(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverse() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public void delete(int employeeId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Employee not found: " + employeeId);
            return;
        }
        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[--count] = null;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(10);
        system.add(new Employee(1, "Mayukh", "Backend Engineer", 95000));
        system.add(new Employee(2, "Priya", "Designer", 70000));
        system.add(new Employee(3, "Karan", "Manager", 120000));

        System.out.println("Search id 2: " + system.search(2));

        system.delete(1);
        System.out.println("\nAfter deleting id 1:");
        system.traverse();
    }
}
