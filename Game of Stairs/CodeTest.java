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
    static Map<String, Integer> pathMap = new HashMap();

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