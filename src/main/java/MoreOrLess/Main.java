package MoreOrLess;


public class Main
{
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(new Model(), view);

        controller.processUser();
    }
}


