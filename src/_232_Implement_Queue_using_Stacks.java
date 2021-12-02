
import java.util.Stack;

public class _232_Implement_Queue_using_Stacks {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
//        queue.push(2);
//        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());

    }

    static class MyQueue {

        private Stack stack;

        public MyQueue() {
            stack = new Stack();
        }

        public void push(int x) {
//            System.out.println("Add:> " + x);

            stack.push(x);
//            System.out.println("size:> " + stack.size());
            System.out.println(stack);
        }

        public int pop() {
            int pop = (int) stack.get(0);
            stack.remove(0);
            return pop ;
        }

        public int peek() {
            return (int) stack.get(0);
        }

        public boolean empty() {
            System.out.println(stack);
            return stack.isEmpty();
        }
    }

}
