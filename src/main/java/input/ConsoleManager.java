package input;

import java.util.Scanner;

public class ConsoleManager implements IOManager {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void display(String str) {
        System.out.println(str);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
