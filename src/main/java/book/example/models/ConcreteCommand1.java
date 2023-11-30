package book.example.models;

public class ConcreteCommand1 implements Command{
    private final Receiver receiver;
    private final String a;
    private final String b;
    private final String c;

    public ConcreteCommand1(Receiver receiver, String a, String b, String c) {
        this.receiver = receiver;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void execute() {
        receiver.operation(a,b,c);
    }
}
