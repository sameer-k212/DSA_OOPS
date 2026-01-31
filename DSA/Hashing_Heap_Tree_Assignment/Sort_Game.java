package DSA.Hashing_Heap_Tree_Assignment;
import java.util.*;
public class Sort_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the minimum salary threshold x
        int x = sc.nextInt();

        // Read the number of employees
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // List to hold employee name and salary pairs
        List<Employee> employees = new ArrayList<>();

        // Read employee names and salaries
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            String name = parts[0];
            int salary = Integer.parseInt(parts[1]);
            employees.add(new Employee(name, salary));
        }

        // Sort the employees based on salary and name
        employees.stream()
                .filter(emp -> emp.salary >= x) // Filter based on salary
                .sorted(Comparator.comparingInt((Employee emp) -> emp.salary).reversed() // Sort by salary in descending order
                        .thenComparing(emp -> emp.name)) // Then sort by name in lexicographical order
                .forEach(emp -> System.out.println(emp.name + " " + emp.salary)); // Print the result
    }
}

// Employee class to hold employee name and salary
class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
