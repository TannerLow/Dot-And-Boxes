package rodeo.o2craft.Output;

public class ConsoleOutput implements TextOutput{

    public ConsoleOutput() {

    }

    @Override
    public void print(String line) {
        System.out.print(line);
    }

    @Override
    public void print(Object object) {
        print(object.toString());
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
