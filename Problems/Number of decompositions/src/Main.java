import java.util.Scanner;
import java.util.Stack;

class Main {

    static void partition(int n) {
        partition(n, n, "");
    }
    static void partition(int n, int max, String prefix) {
        if (n == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 1; i <= Math.min(max, n); i++) {
            partition(n-i, i, prefix + " " + i);
        }
    }

    static void decompose(Stack<Integer> stack, int n) {
        Stack<Integer> newstack = new Stack<>();
        Stack<Integer> xstack = new Stack<>();

        if (stack.peek() == n) {
            return;
        } else if (stack.size() > 1) {
            xstack.addAll(stack);
            xstack.push(xstack.pop()+xstack.pop());
            while (stack.size() > 1) {

                newstack.push(stack.pop()+stack.pop());
                printStack(newstack);
                printStack(stack);
                System.out.println();

                if (!stack.empty()) {
                    if (newstack.peek()+stack.peek() <= xstack.peek()) {
                        newstack.push(newstack.pop() + stack.pop());
                        printStack(newstack);
                        printStack(stack);
                        System.out.println();
                    }
                }

            }
            if (stack.size() == 1) {
                if (newstack.peek()+stack.peek() <= xstack.peek()) {
                    newstack.push(newstack.pop() + stack.pop());
                    printStack(newstack);
                    System.out.println();
                }
            }
            decompose(xstack, n);
        }

    }

    static void printStack(Stack<Integer> stack) {
        for (Integer i: stack) {
            System.out.print(i + " ");
        }
    }

    static Stack<Integer> createStack(int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            stack.push(1);
        }
        printStack(stack);
        System.out.println();
        return stack;
    }

    static void expand(int n) {
        Stack<Integer> stack = createStack(n);
        decompose(stack, n);
    }

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        partition(scanner.nextInt());
    }
}