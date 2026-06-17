package todo;

import java.util.ArrayList;
import java.util.List;

public class TodoListManager {
    private final List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public String getTask(int index) {
            return tasks.get(index);
    }

    public void completeTask(int index) {
        tasks.remove(index);
    }

    public List<String> listTasks() {
        System.out.print("List of tasks: ");
        return new ArrayList<>(tasks);
    }

    public int size() {
        return tasks.size();
    }
}
