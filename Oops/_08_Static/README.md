# Static Keyword

## Concept
Belongs to class rather than instance. Shared among all objects.

## Key Topics
- Static variables (class variables)
- Static methods
- Static blocks
- Static nested classes
- Static import
- Context conflicts

## Folders
- `_1_StaticVariable/` - Static variable examples
- `_2_StaticMethod/` - Static method examples
- `_3_StaticBlocks/` - Static block initialization
- `_4_StaticClass/` - Static nested classes
- `_5_StaticImport/` - Static import usage
- `_6_ContextConflict/` - Resolving conflicts

## Files
- `Launch.java`, `LaunchStatic.java`, `Static1.java` - Various examples

## Example
```java
class Counter {
    static int count = 0;  // Shared by all objects
    
    Counter() {
        count++;
    }
    
    static void showCount() {
        System.out.println("Count: " + count);
    }
}
```

## Rules
- Static method can't access non-static members directly
- Static method can't use this/super
- Static block executes before main method
- Static variables initialized only once
