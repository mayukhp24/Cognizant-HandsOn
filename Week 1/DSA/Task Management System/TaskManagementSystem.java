class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class TaskManagementSystem {
    private Task head;

    public void add(int taskId, String taskName, String status) {
        Task task = new Task(taskId, taskName, status);
        if (head == null) {
            head = task;
            return;
        }
        Task current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = task;
    }

    public Task search(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void traverse() {
        Task current = head;
        while (current != null) {
            System.out.println(current.taskId + " | " + current.taskName + " | " + current.status);
            current = current.next;
        }
    }

    public void delete(int taskId) {
        if (head == null) return;
        if (head.taskId == taskId) {
            head = head.next;
            return;
        }
        Task current = head;
        while (current.next != null && current.next.taskId != taskId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();
        system.add(1, "Finish report", "Pending");
        system.add(2, "Review PR", "In Progress");
        system.add(3, "Deploy build", "Pending");

        Task found = system.search(2);
        System.out.println("Found: " + (found != null ? found.taskName : "none"));

        system.delete(1);
        System.out.println("\nRemaining tasks:");
        system.traverse();
    }
}
