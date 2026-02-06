# Date and Time API (Java 8)

## Concept
Modern date and time handling. Replaces old Date and Calendar classes.

## Key Classes
- **LocalDate** - Date without time (2024-01-15)
- **LocalTime** - Time without date (10:30:45)
- **LocalDateTime** - Date and time (2024-01-15T10:30:45)
- **ZonedDateTime** - Date, time with timezone
- **Period** - Date-based amount (years, months, days)
- **Duration** - Time-based amount (hours, minutes, seconds)

## Folders
- `_1_Date_Time/` - Date/Time examples

## Example
```java
// Current date and time
LocalDate today = LocalDate.now();
LocalTime now = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();

// Create specific date
LocalDate date = LocalDate.of(2024, 1, 15);
LocalTime time = LocalTime.of(10, 30, 45);

// Operations
LocalDate tomorrow = today.plusDays(1);
LocalDate lastWeek = today.minusWeeks(1);

// Formatting
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
String formattedDate = today.format(formatter);

// Period between dates
Period period = Period.between(date1, date2);
System.out.println(period.getYears() + " years");
```

## Benefits
- Immutable and thread-safe
- Clear API
- Better timezone handling
- More operations available
