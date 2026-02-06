# Polymorphism

## Concept
Ability of an object to take many forms. "One interface, multiple implementations."

## Types

### 1. Compile-time Polymorphism (Method Overloading)
- Same method name, different parameters
- Resolved at compile time

### 2. Runtime Polymorphism (Method Overriding)
- Same method signature in parent and child
- Resolved at runtime

## Folders
- `MethodOverloading/` - Overloading examples
- `MethodOverriding/` - Overriding examples

## Example
```java
// Overloading
class Calculator {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}

// Overriding
class Animal {
    void sound() { System.out.println("Animal sound"); }
}
class Dog extends Animal {
    void sound() { System.out.println("Bark"); }
}
```
