package SESSION08.SESSION08_05;

import java.util.*;

class SleepModeCommand implements Command {
    private List<Command> commands;

    public SleepModeCommand(List<Command> commands) {
        this.commands = commands;
    }

    public void execute() {
        for (Command c : commands) {
            c.execute();
        }
    }
}