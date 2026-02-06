# File I/O and Serialization

## Concept
Reading from and writing to files. Serialization converts objects to byte stream.

## Key Topics
- File operations (create, read, write, delete)
- FileReader, FileWriter
- BufferedReader, BufferedWriter
- PrintWriter
- Serialization
- Deserialization
- Transient keyword

## Folders
- `_0_Introduction/` - I/O basics
- `_1_CreatingFile/` - File creation
- `_2_ReadingFile/` - File reading
- `_3_BufferWriter/` - BufferedWriter usage
- `_4_BufferReader/` - BufferedReader usage
- `_5_PrintWriter/` - PrintWriter usage
- `_6_Serialization/` - Object serialization
- `_7_Deserialization/` - Object deserialization
- `_8_SelectiveSerialization/` - Transient keyword
- `_9_Summary/` - Complete examples

## Example
```java
// Write to file
FileWriter fw = new FileWriter("file.txt");
fw.write("Hello World");
fw.close();

// Read from file
BufferedReader br = new BufferedReader(new FileReader("file.txt"));
String line;
while((line = br.readLine()) != null) {
    System.out.println(line);
}
br.close();

// Serialization
class Student implements Serializable {
    String name;
    transient int password;  // Won't be serialized
}

ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"));
oos.writeObject(student);
```
