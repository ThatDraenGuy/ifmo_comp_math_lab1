package commands;

import data.Range;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;

@Getter
@AllArgsConstructor
public class CommandArgs {
    private final int num;
    private final File file;
    private final Range range;
    private final ArgsType type;
}
