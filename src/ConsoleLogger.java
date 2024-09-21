public class ConsoleLogger implements Loggable {
    @Override
    public void log(String msg) {
        System.out.println(msg);
    }
}
