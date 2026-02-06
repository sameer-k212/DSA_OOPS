# Interface

## Concept
Blueprint of a class. Achieves 100% abstraction and multiple inheritance.

## Key Topics
- Interface declaration
- Implementing interfaces
- Multiple interface implementation
- Default methods (Java 8)
- Static methods in interface
- Functional interfaces
- Lambda expressions
- Anonymous inner classes

## Folders
- `FunctionalInterface/` - @FunctionalInterface examples

## Files
- `_0_NeedOfInterface.java` - Why interfaces?
- `_1_LaunchAbs.java` - Interface basics
- `Intro.java` - Introduction
- `MultipleInterface.java` - Multiple inheritance
- `Java8Feature.java` - Java 8 features
- `LembdaExp.java` - Lambda expressions
- `AnonymousInnerClass.java` - Anonymous classes
- `InnerClassDemo.java` - Inner class examples

## Example
```java
interface Animal {
    void sound();  // public abstract by default
    
    default void sleep() {  // Java 8
        System.out.println("Sleeping...");
    }
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Bark");
    }
}
```

## Rules
- All methods are public abstract by default
- All variables are public static final
- Cannot instantiate interface
- Class can implement multiple interfaces
