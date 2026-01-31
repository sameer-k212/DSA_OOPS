# Trapping Rain Water

## 📝 Problem
Calculate water trapped after raining

## 💡 Core Concept
- Two pointers with leftMax and rightMax
- Water at position = min(leftMax, rightMax) - height
- Process from smaller side

## 🔄 Example
```
[0,1,0,2,1,0,1,3,2,1,2,1]
       █
   █ ~ █ █ ~ █
 █ █ █ █ █ █ █
Water = 6 units
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(1)

## 💻 Code
```java
public static int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0, water = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= leftMax) leftMax = height[left];
            else water += leftMax - height[left];
            left++;
        } else {
            if (height[right] >= rightMax) rightMax = height[right];
            else water += rightMax - height[right];
            right--;
        }
    }
    return water;
}
```
