package todo;

public class TodoDemo {
    public static void main(String[] args) {
        // TODO: add tasks, print, complete one, print again
        TodoListManager manager = new TodoListManager();

        // add tasks
        manager.addTask("Buy groceries");
        manager.addTask("Feed the dogs");
        manager.addTask("Study");

        // list
        System.out.println(manager.listTasks());

        // completed task one 
        manager.completeTask(0);
        System.out.println("Completed a task");

        // list again
        System.out.println(manager.listTasks());

        // exception
        try {
            manager.getTask(99);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught IndexOutOfBoundsException: " + e.getMessage());
        }
    }
}