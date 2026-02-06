# Inheritance

## Concept
Mechanism where one class acquires properties and methods of another class.

## Key Topics
- Single inheritance
- Multilevel inheritance
- Hierarchical inheritance
- Method overriding
- super keyword
- IS-A relationship

## Files
- `Inheritance.java` - Complete inheritance examples

## Example
```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}
```

## Note
Java doesn't support multiple inheritance with classes (use interfaces instead).
