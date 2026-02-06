# Streams API (Java 8)

## Concept
Process collections of objects in functional style. Supports operations like filter, map, reduce.

## Key Topics
- Stream creation
- Intermediate operations (filter, map, sorted)
- Terminal operations (collect, forEach, reduce)
- Parallel streams
- Collectors
- Lazy evaluation

## Files
- `StreamDemo.java` - Basic stream operations
- `IntermediateOps.java` - Intermediate operations
- `TerminalOps.java` - Terminal operations
- `CollectorsDemo.java` - Collectors usage
- `ParallelStream.java` - Parallel processing
- `PrimitiveStreams.java` - IntStream, LongStream, DoubleStream
- `LazyEvaluationDemo.java` - Lazy evaluation concept

## Example
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

// Filter even numbers and square them
List<Integer> result = numbers.stream()
    .filter(n -> n % 2 == 0)
    .map(n -> n * n)
    .collect(Collectors.toList());
// Result: [4, 16, 36]

// Sum of all numbers
int sum = numbers.stream()
    .reduce(0, (a, b) -> a + b);

// Parallel stream
numbers.parallelStream()
    .forEach(System.out::println);
```

## Operations
**Intermediate**: filter, map, sorted, distinct, limit, skip  
**Terminal**: forEach, collect, reduce, count, anyMatch, allMatch
