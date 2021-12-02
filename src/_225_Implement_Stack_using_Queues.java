import java.util.*;

public class _225_Implement_Stack_using_Queues {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.empty());

//        Stack<Integer> path = new Stack<>();
//        path.push(1);
//        path.push(2);
//        path.push(3);
//        path.push(4);
//        path.push(5);
//        System.out.println(path);
    }


    static class MyStack {

        Queue<Integer> queue = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            queue.add(x);
            for (int i = 1; i < queue.size(); i++)
                queue.add(queue.remove());
            System.out.println("queue.size():> " + queue.size());
            System.out.println(queue);
        }

        public int pop() {
            System.out.println("pop :> queue.size():> " + queue.size());
            return queue.remove();
        }

        public int top() {
            System.out.println("top :> queue.size():> " + queue.size());
            return queue.peek();
        }

        public boolean empty() {
            System.out.println(queue);
            return queue.isEmpty();
        }
    }
}
