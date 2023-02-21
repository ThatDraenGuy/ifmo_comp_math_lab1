package draen.input;

import draen.data.application.Config;
import draen.data.transfer.Equation;
import lombok.AllArgsConstructor;

import java.io.*;
import java.util.Iterator;

@AllArgsConstructor
public class FileInputManager implements MatrixInputManager {
    private final File source;

    @Override
    public String getName() {
        return "file";
    }

    @Override
    public Equation readEquation(Config config) {
        return null;
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(source)));
//
//        } catch (FileNotFoundException e) {
//
//        }
    }

    private void parseLines(Iterator<String> iterator, Config config) {
        while (iterator.hasNext()) {
            String line = iterator.next();
            String[] split = line.split("=");
            String key = split[0];

        }
    }
}
