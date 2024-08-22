import java.util.ArrayList;

public class Response {
    public void greet() {
        line();
        System.out.println("Hello! I'm Tanjiro!");
        System.out.println("What can I do for you?");
        line();
    }

    public void goodbye() {
        System.out.println("Bye! Hope to see you again!");
        line();
    }

//    public void added_task_message(Task t) {
//        System.out.println("Got it. I've added this task:");
//        if (t.getTag().equals("T")) {
//            System.out.println("[T][ ] " + t.getName());
//        }
//        System.out.println("Now you have " + t.get_list_size() +" tasks in the list.");
//    }

    public void list_task_message(ArrayList<Task> task_list) {
        int counter = 1;
        for (Task t : task_list) {
            if (t.getStatus()) {
                if (t.getTag().equals("T")) {
                    System.out.println(counter + ".[T][X] " + t.getName());
                } else if (t.getTag().equals("D")) {
                    System.out.println(counter + ".[D][X] " + t.getName());
                } else if (t.getTag().equals("E")) {
                    System.out.println(counter + ".[E][X] " + t.getName());
                }
            } else {
                if (t.getTag().equals("T")) {
                    System.out.println(counter + ".[T][ ] " + t.getName());
                } else if (t.getTag().equals("D")) {
                    System.out.println(counter + ".[D][ ] " + t.getName());
                } else if (t.getTag().equals("E")) {
                    System.out.println(counter + ".[E][ ] " + t.getName());
                }
            }
            counter++;
        }

    }

    public void mark_message(String s) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[X] " + s);
    }

    public void unmark_message(String s) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("[ ] " + s);
    }

    private void line() {
        System.out.println("========================================");
    }

}
