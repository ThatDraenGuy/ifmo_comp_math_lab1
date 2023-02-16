package draen.input;

import lombok.AllArgsConstructor;

import java.io.File;

@AllArgsConstructor
public class FileInputManager implements MatrixInputManager {
    private final File source;
}
