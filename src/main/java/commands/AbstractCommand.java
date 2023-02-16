package commands;

import lombok.Getter;

public abstract class AbstractCommand implements Command {
    @Getter
    private final CommandData data;

    protected AbstractCommand(CommandData data) {
        this.data = data;
    }
}
