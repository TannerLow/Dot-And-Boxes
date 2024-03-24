package rodeo.o2craft.Output;

public interface TextOutput {
    void print(String line);
    void print(Object object);
    void printLine(String line);
    void printLine(Object object);
}
