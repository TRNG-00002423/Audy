import java.util.PriorityQueue;
import java.util.Queue;


/** Partner B — drain PriorityQueue in priority order. */
public class TaskQueueApp {
    public static void main(String[] args) {
        Queue<Task> q = new PriorityQueue<>();
        // TODO: offer tasks out of order, poll and print, peek demo
        q.add(new Task(1, "walk dog"));
        q.add(new Task(3, "cooking"));
        q.add(new Task(2, "guitar"));

        System.out.println(q.peek());

        while (!q.isEmpty()) {
            Task task = q.poll();
            System.out.println(task);
        }
    }
}
