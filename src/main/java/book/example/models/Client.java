package book.example.models;

public class Client {

    public static void main(String[] args) {

        Receiver receiver = new Receiver();


        Command concreteCommand1 = new ConcreteCommand1(receiver, "param1","param2","param3");


        Command concreteCommand2 = new ConcreteCommand2();


        Invoker invoker = new Invoker();
        invoker.setCommand(concreteCommand1);
        invoker.executeCommand();

        invoker.setCommand(concreteCommand2);
        invoker.executeCommand();
    }
}
