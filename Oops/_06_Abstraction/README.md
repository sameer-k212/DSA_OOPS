# Abstraction

## Concept
Hiding implementation details and showing only functionality. Focus on "what" not "how".

## Key Topics
- Abstract classes
- Abstract methods
- Concrete methods in abstract class
- Cannot instantiate abstract class
- 0-100% abstraction possible

## Files
- `Abstraction.java` - Abstract class examples

## Example
```java
abstract class Animal {
    abstract void sound();  // Abstract method
    
    void sleep() {  // Concrete method
        System.out.println("Sleeping...");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}
```

## Rules
- Abstract class can have abstract and non-abstract methods
- If class has abstract method, class must be abstract
- Abstract method has no body
- Child class must implement all abstract methods
