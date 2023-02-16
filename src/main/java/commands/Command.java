package commands;

public interface Command {
    void execute(CommandArgs args, CommandContext context);
    CommandData getData();
}
