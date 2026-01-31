# Stack Using Queues

## 📝 Problem
Implement stack using two queues

## 💡 Core Concept
- Use q1 as main queue (maintains stack order)
- Use q2 as helper during push
- Push new element to q2, transfer q1 to q2, swap queues

## 🔄 Example
```
push(1): q1=[1]
push(2): q2=[2], transfer q1 → q2=[2,1], swap → q1=[2,1]
push(3): q2=[3], transfer q1 → q2=[3,2,1], swap → q1=[3,2,1]
pop(): return 3, q1=[2,1]
```

## ⚡ Complexity
- **Push**: O(n)
- **Pop**: O(1)
- **Top**: O(1)
- **Space**: O(n)

## 💻 Code
```java
class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    
    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        return q1.isEmpty() ? -1 : q1.remove();
    }
    
    public int top() {
        return q1.isEmpty() ? -1 : q1.peek();
    }
}
```
