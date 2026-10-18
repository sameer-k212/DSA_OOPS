
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ": " + age;
    }
}

public class Main {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        };

        List<Person> olderThan30 = Arrays.stream(people)
                .filter(person -> person.age > 30)
                .collect(Collectors.toList());

        System.out.println("People older than 30: " + olderThan30);
    }
}
