import java.util.*;

public class Result {
    Stack<Character> stack = new Stack<>();
    Queue<Character> queue = new LinkedList<>();


    void pushCharacter(char ch){
        stack.push(ch);
    }
    void enqueueCharacter(char ch){
        queue.add(ch);
    }

    char popCharacter() {
        return stack.pop();
    }
    char dequeueCharacter() {
        return queue.remove();
    }
    public static String test(String input){
        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Result p = new Result();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        //System.out.println( );
        return "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." );
    }

    public static void main(String[] args) {

        System.out.println(test("repaper"));
        System.out.println(test("test"));
        System.out.println(test("racecar"));

    }
}
