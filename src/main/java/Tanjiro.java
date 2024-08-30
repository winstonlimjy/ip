import commands.TaskList;
import storage.Storage;
import system.Ui;
import system.InputProcessor;
import system.Parser;

import java.io.IOException;

public class Tanjiro {
    public static void main(String[] args) throws IOException {
        Ui ui = new Ui();
        InputProcessor i = new InputProcessor();
        Storage fs = new Storage();
        fs.createFile();
        TaskList.init_list();
        Parser p = new Parser();

        ui.greet();

        String user_input = i.read().toLowerCase();
        while (!p.containBye(user_input)) {
            if (p.containList(user_input)) {
                p.performListTasks();
            } else if (p.containMark(user_input)) {
                p.performMark(user_input);
            } else if (p.containToDo(user_input)) {
                p.performToDo(user_input);
            } else if (p.containDeadline(user_input)) {
                p.performDeadline(user_input);
            } else if (p.containEvent(user_input)) {
                p.performEvent(user_input);
            } else if (p.containDelete(user_input)) {
                p.performDelete(user_input);
            } else if (p.containFind(user_input)) {
                p.performFind(user_input);
            } else {
                ui.invalid_input();
            }
            user_input = i.read().toLowerCase();
        }

        ui.goodbye();

    }

}
