## Game of Stairs

Ron is playing a video game called Staircase Saga in which there is a staircase with an infinite
number of steps; with markings starting from 1 (the lowermost stair) and the ground marked
as 0. The goal of the player is to move the character from the **1<sup>st</sup>** to the **M<sup>th</sup>** stair. He must
adhere to the following rules in the game:
<br/>
* At the start of the game, the player is on the 1st stair (the lowermost stair)
Pressing the Up button will result in the character moving up the stairs in progressive
powers of 2 (2<sup>0</sup>, 2<sup>1</sup>, 2<sup>2</sup>,...).
* Pressing the Down button will bring the player-1 stair down but the button cannot be
pressed consecutively.
<br/>

You must help Ron to find and return an integer value representing the number of ways in
which the character can be moved from the **1<sup>st</sup>** stair to the **M<sup>th</sup>** stair.
<br/>
#### Input Specification:
```
input1:An integer value M, representing the destination stair of the player.
```
### Output Specification:
```
Return an integer value representing the number of ways in which the character can be
moved from the 1st stair to the Mth stair.
```
### Example 1
```dtd
Input : 2
```
```dtd
Output : 4
```

### Explanation:
The possible ways of going from the **1<sup>st</sup>** stair to the **2<sup>nd</sup>** stair using the Up and Down buttons
are outlined below:
<br/>

1. 1->2
2. 1->0->1->0->2
3. 1->0->1->3->2
4. 1->2->1->3->2
5. 1->0->2 (This way is not possible as pressing the Up button moves the character only
   in progressive powers of 2. Therefore, when the character is moved from 1st to ground,
   it will move 2<sup>0</sup> = 1 step upward and not directly by steps 2<sup>1</sup> = 2 steps).
<br>

There are 4 possible ways of reaching stair 2 from stair 1. Therefore, 4 will be returned as the
answer.
<br>


### Example 2
```dtd
Input : 1
```
```dtd
Output : 4
```

### Explanation:
Applying the same logic as given above, the possible ways of reaching stair 1 from stair 1 are:
<br/>
1. Staying on the **1<sup>st</sup>** stair.
2. 1->0->1
3. 1->2->1
4. 1->0->1->0->2->1
<br>

There are 4 possible ways of reaching stair 1 from stair 1. Therefore, 4 will be returned as the
answer.
<br>


## Solution

```java
package <YOUR_PACKAGE_HERE>

import java.util.HashMap;
import java.util.Map;

public class CodeTest {
    public static void main(String[] args) {
        int input = 3;
        System.out.println("Possible ways= " + gameOfStairs(input));
    }

    public static int gameOfStairs(int input1) {
        findNoOfWays(input1, 1, false, 0);
        findNoOfWays(input1, 1, true, 0);
        return m;
    }

    static int m = 0;
    static String path = "";
    static Map<String, Integer> pathMap = new HashMap<>();

    public static int findNoOfWays(int n, int currentStep, boolean isPreviousMoveDown, int nextPowerOfTwo) {
        if (currentStep > n + 2) {
            return m;
        }
        path += "," + currentStep;
        if (currentStep == n) {
            if (!pathMap.containsKey(path)) {
                System.out.println("path=" + path);
                pathMap.put(path, 1);
                m = m + 1;
            }
            if (!pathMap.containsKey(path)) {
                path = removePath(path, "," + currentStep);
                return m;
            }
        }
        if (isPreviousMoveDown) {
            int step = (int) Math.pow(2, nextPowerOfTwo);
            findNoOfWays(n, (currentStep + step), false, nextPowerOfTwo + 1);
        } else {
            findNoOfWays(n, (currentStep - 1), true, nextPowerOfTwo);
            int step = (int) Math.pow(2, nextPowerOfTwo);
            findNoOfWays(n, (currentStep + step), false, nextPowerOfTwo + 1);
        }
        path = removePath(path, "," + currentStep);
        return m;
    }

    public static String removePath(String path, String step) {
        return path.substring(0, path.length() - step.length());
    }
}
```