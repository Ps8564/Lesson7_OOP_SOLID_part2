public class Main {
    public static void main(String[] args) {
        ICalculableFactory calculableFactory = new LogCalculableFactory(new ConsoleLogger());
        ViewCalculator view = new ViewCalculator(calculableFactory);
        view.task();
        view.run();
        view.end();
    }
}