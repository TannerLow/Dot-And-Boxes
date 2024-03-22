package rodeo.o2craft.Input;

import java.util.Scanner;

public class ConsoleInput implements TextInput {
    private Scanner scanner;

    public ConsoleInput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        String inputString = "";
        try {
            inputString = scanner.nextLine();
        }
        catch(Exception e) {
            // do nothing
        }

        return inputString;
    }
}
