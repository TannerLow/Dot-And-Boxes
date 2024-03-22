package rodeo.o2craft.Output;

public class ConsoleOutput implements TextOutput{

    public ConsoleOutput() {

    }

    @Override
    public void printLine(String line) {
        System.out.println(line);
    }

    @Override
    public void printLine(Object object) {
        printLine(object.toString());
    }
}
