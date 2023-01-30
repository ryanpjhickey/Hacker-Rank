import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here

        Collections.sort(a);
        Stack<Integer> lonelyStack = new Stack<Integer>();

        if (a.size() == 1) {
            return a.get(0);
        }

        for (int i = 0; i < a.size(); i++) {
            if (lonelyStack.isEmpty()) {
                lonelyStack.push(a.get(i));
            } else if (lonelyStack.peek() == a.get(i)) {
                lonelyStack.pop();
            } else {
                break;
            }
        }

        return lonelyStack.peek();

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);
        System.out.println(
                "Please enter a list of numbers. List all numbers twice in any order. List a single number once instead of twice. This program will find that odd number out.");

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.lonelyinteger(a);

        System.out.println(result);

        bufferedReader.close();
        isr.close();
    }
}
