package system;

import java.time.LocalDateTime;

import task.Deadlines;
import task.Events;
import task.Task;
import task.ToDos;

/**
 * The Ui class is responsible for providing user interface interactions
 * and generating appropriate response messages for various user actions.
 * It includes methods to display greetings, instructions, task statuses,
 * and error messages.
 */
public class Ui {
    /**
     * Displays messages greeting the user as well as providing instructions to use the chatbot.
     */
    public String greet() {
        return "Hello! I'm Tanjiro!\n"
                + "What can I do for you?\n"
                + "Instructions:\n"
                + "todo *_name_* \n"
                + "deadline *_name_* /by *_date_* [Date Format: yyyy-mm-dd hhmm]\n"
                + "event *_name_* /from *_date_* /to *_date_* [Date Format: yyyy-mm-dd hhmm]\n"
                + "find *_name_*\n"
                + "view *_date_* [Date Format: yyyy-mm-dd]\n";
    }

    /**
     * Displays a message saying goodbye as a salutation.
     *
     * @return a String message displaying goodbye.
     */
    public String goodbye() {
        return "Bye! Hope to see you again!";
    }

    /**
     * Displays a message saying hello as a salutation.
     *
     * @return a String message displaying hello.
     */
    public String hi() {
        return "Hello! What can I do for you?";
    }

    /**
     * Displays a message giving self introduction.
     *
     * @return a String message displaying an introduction message.
     */
    public String introduction() {
        return "My name is Tanjiro and I can do many things, such as:\n"
                + "todo *_name_* \n"
                + "deadline *_name_* /by *_date_* [Date Format: yyyy-mm-dd hhmm]\n"
                + "event *_name_* /from *_date_* /to *_date_* [Date Format: yyyy-mm-dd hhmm]\n"
                + "find *_name_*\n"
                + "view *_date_* [Date Format: yyyy-mm-dd]\n";
    }

    /**
     * Displays a message indicating that the task list is currently empty.
     *
     * @return a String message displaying empty list.
     */
    public String emptyList() {
        return "There are currently zero tasks in the list!";
    }

    /**
     * Displays a message indicating that the task does not exist.
     *
     * @return a String message displaying task does not exist.
     */
    public String doesNotExist() {
        return "Task does not exist!";
    }

    /**
     * Displays a message indicating that the task has already been marked.
     *
     * @return a String message displaying task is already marked.
     */
    public String alreadyMarked() {
        return "Task has already been marked!";
    }

    /**
     * Displays a message indicating that the task has already been unmarked.
     *
     * @return a String message displaying task is already unmarked.
     */
    public String alreadyUnmarked() {
        return "Task has already been unmarked!";
    }

    /**
     * Displays a message indicating that a task has been removed from the task list.
     * The method outputs details about the removed task,
     * such as the name, status, and relevant date information whenever applicable.
     * It also displays the updated number of tasks in the list.
     *
     * @param t Task that has been removed, which can be an instance of ToDos, Deadlines, or Events.
     * @return a String message displaying task is deleted.
     */
    public String delete_message(Task t) {
        StringBuilder response = new StringBuilder();
        DateTimeSystem dateTimeSystem = new DateTimeSystem();
        response.append("Noted. I've removed this task:\n");
        if (t instanceof ToDos) {
            if (t.getCurrentStatus() == Task.Status.MARKED) {
                response.append("[T][X] ").append(t.getName()).append("\n");
            } else {
                response.append("[T][_] ").append(t.getName()).append("\n");
            }
        } else if (t instanceof Deadlines) {
            if (t.getCurrentStatus() == Task.Status.MARKED) {
                response.append("[D][X] ").append(t.getName()).append(" (by: ")
                        .append(dateTimeSystem.formatLocalTimeDate(t.getDate())).append(")\n");
            } else {
                response.append("[D][_] ").append(t.getName()).append(" (by: ")
                        .append(dateTimeSystem.formatLocalTimeDate(t.getDate())).append(")\n");
            }
        } else if (t instanceof Events) {
            if (t.getCurrentStatus() == Task.Status.MARKED) {
                response.append("[E][X] ").append(t.getName()).append(" (from: ")
                        .append(dateTimeSystem.formatLocalTimeDate(t.getStart())).append(" to: ")
                        .append(dateTimeSystem.formatLocalTimeDate(t.getEnd())).append(")\n");
            } else {
                response.append("[E][_] ").append(t.getName()).append(" (from: ")
                        .append(dateTimeSystem.formatLocalTimeDate(t.getStart())).append(" to: ")
                        .append(dateTimeSystem.formatLocalTimeDate(t.getEnd())).append(")\n");
            }
        }
        response.append("Now you have ").append(t.get_list_size()).append(" tasks in the list.");

        return response.toString();
    }

    /**
     * Displays a message indicating the matching tasks in a list.
     * This method prints a header message followed by the content of
     * the StringBuilder object which contains the found tasks.
     *
     * @param sb StringBuilder object that holds the found tasks to be displayed.
     * @return a String message displaying task that was found based on the input.
     */
    public String findTaskMessage(StringBuilder sb) {
        return "Here are the matching tasks in your list:\n"
                + sb.toString();
    }

    /**
     * Displays a message indicating the matching tasks in a list with the given date.
     * This method prints a message followed by the content of the matching task.
     *
     * @param date a String that represents the date.
     * @param sb   StringBuilder object that holds the found tasks to be displayed.
     * @return a String message displaying task that was found based on the date.
     */
    public String viewTaskMessage(String date, StringBuilder sb) {
        return "Here are the matching tasks for this date: "
                + date + "\n"
                + sb.toString();
    }

    /**
     * Displays a message indicating that the date provided is invalid.
     *
     * @return a String message displaying invalid date format.
     */
    public String invalidDate() {
        return "The date provided is invalid! Please type in this format: yyyy-mm-dd HHmm. Thanks!";
    }

    /**
     * Displays a message indicating that the command provided is in invalid format.
     *
     * @return a String message displaying invalid command format.
     */
    public String invalidCommand() {
        return "The command is not in the correct format! Please try again!";
    }

    /**
     * Displays a message indicating that no task has been found.
     *
     * @return a String message displaying no task has been found.
     */
    public String noTaskFound() {
        return "There are no tasks found!";
    }

    /**
     * Displays a message indicating that the deadline format provided is invalid.
     *
     * @return a String message displaying invalid deadline format.
     */
    public String invalidDeadlineInput() {
        return "Deadline input is invalid. Please type in this format: deadline ___ /by yyyy-mm-dd HHmm. Thanks!";
    }

    /**
     * Displays a message indicating that the event format provided is invalid.
     *
     * @return a String message displaying invalid event format.
     */
    public String invalidEventInput() {
        return "Event input is invalid. Please type in this format: "
                + "event ___ /from yyyy-mm-dd HHmm /to yyyy-mm-dd HHmm. Thanks!";
    }

    public String twentyFourHourClock() {
        return "Please enter the time in the 24-hour time format. Thanks!";
    }

    /**
     * Displays a message containing the list of tasks in a given specific format.
     *
     * @param information Information string containing the list of tasks.
     * @return a String message displaying all the tasks in the list.
     */
    public String list_task_message(String information) {
        return information;
    }

    /**
     * Displays a message indicating that the task has been marked.
     *
     * @return a String message displaying the marking of a task.
     */
    public String mark_message(String s) {
        return "Nice! I've marked this task as done:\n"
                + "[X] " + s;
    }

    /**
     * Displays a message indicating that the task has been unmarked.
     *
     * @return a String message displaying the unmarking of a task.
     */
    public String unmark_message(String s) {
        return "OK, I've unmarked this task as not done yet:\n"
                + "[_] " + s;
    }

    /**
     * Displays a message indicating that the to-do task cannot be empty.
     *
     * @return a String message displaying that a to-do task cannot be empty.
     */
    public String empty_todo() {
        return "OOPS!!! The description of a todo cannot be empty.";
    }

    /**
     * Displays a message indicating the adding of a to-do task.
     *
     * @return a String message displaying the success of adding a to-do task.
     */
    public String addTodoMessage(ToDos t) {
        return "Got it. I've added this task:\n"
                + "[T][_] " + t.getName()
                + "\nNow you have " + t.get_list_size() + " tasks in the list.";
    }

    /**
     * Displays a message indicating the adding of a deadline task.
     *
     * @return a String message displaying the success of adding a deadline task.
     */
    public String addDeadlineMessage(Deadlines d, LocalDateTime date) {
        DateTimeSystem dateTimeSystem = new DateTimeSystem();
        return "Got it. I've added this task:\n"
                + "[D][_] " + d.getName() + "(by: " + dateTimeSystem.formatLocalTimeDate(date) + ")\n"
                + "Now you have " + d.get_list_size() + " tasks in the list.";
    }

    /**
     * Displays a message indicating the adding of an event task.
     *
     * @return a String message displaying the success of adding an event task.
     */
    public String addEventMessage(Events e, LocalDateTime start, LocalDateTime end) {
        DateTimeSystem dateTimeSystem = new DateTimeSystem();

        return "Got it. I've added this task:\n"
                + "[E][_] " + e.getName() + "(from: "
                + dateTimeSystem.formatLocalTimeDate(start) + " to: " + dateTimeSystem.formatLocalTimeDate(end) + ")\n"
                + "Now you have " + e.get_list_size() + " tasks in the list.";
    }

    /**
     * Displays a message indicating that the deadline format is invalid.
     *
     * @return a String message displaying the invalid deadline format.
     */
    public String empty_deadline() {
        return "OOPS!!! The format of a deadline is wrong.";
    }

    /**
     * Displays a message indicating that the event format is invalid.
     *
     * @return a String message displaying the invalid event format.
     */
    public String empty_event() {
        return "OOPS!!! The format of a event is wrong.";
    }

    /**
     * Displays a message indicating that the input format is not understandable.
     *
     * @return a String message displaying the invalid input format.
     */
    public String invalidInput() {
        return "OOPS!!! I'm sorry, but I don't know what that means :-(";
    }

    /**
     * Displays a message indicating that the date/time is invalid.
     *
     * @return a String message displaying the invalid date/time.
     */
    public String dateBeforeCurrent() {
        return "Invalid date/time as it is before current date/time!";
    }

    /**
     * Displays a message indicating that the list number is
     * out of bounds and does not exist.
     *
     * @return a String message displaying the invalid list number and does not exist.
     */
    public String indexOutOfBounds() {
        return "The list number is invalid and does not exist!";
    }
}
