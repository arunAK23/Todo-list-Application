import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TodoList {
    private List<String> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Todo List Application!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    System.out.print("Enter the task: ");
                    String task = scanner.nextLine();
                    todoList.addTask(task);
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    System.out.print("Enter the task index to delete: ");
                    int index = scanner.nextInt();
                    todoList.deleteTask(index - 1);
                    break;
                case 3:
                    todoList.displayTasks();
                    break;
                case 4:
                    System.out.println("Exiting Todo List Application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
