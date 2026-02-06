# Comparable and Comparator

## Concept
Interfaces used to sort custom objects.

## Comparable
- Single sorting sequence
- Modifies actual class
- compareTo() method
- java.lang package

## Comparator
- Multiple sorting sequences
- Separate class
- compare() method
- java.util package

## Folders
- `Comparable/` - Comparable interface examples
- `Comparator/` - Comparator interface examples

## Example
```java
// Comparable
class Student implements Comparable<Student> {
    int id;
    String name;
    
    public int compareTo(Student s) {
        return this.id - s.id;  // Sort by id
    }
}

// Comparator
class NameComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);  // Sort by name
    }
}

// Usage
Collections.sort(list);  // Comparable
Collections.sort(list, new NameComparator());  // Comparator
```

## When to Use
- **Comparable**: Natural ordering (default sorting)
- **Comparator**: Custom ordering (multiple ways to sort)
