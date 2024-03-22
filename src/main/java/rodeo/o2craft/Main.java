package rodeo.o2craft;

import rodeo.o2craft.Input.ConsoleInput;
import rodeo.o2craft.Input.TextInput;
import rodeo.o2craft.Output.ConsoleOutput;
import rodeo.o2craft.Output.TextOutput;

public class Main {
    public static void main(String[] args) {
        TextInput input = new ConsoleInput();
        TextOutput output = new ConsoleOutput();

        String userInput = input.getInput();
        output.printLine(userInput);
    }
}