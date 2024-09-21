public class CalculableFactory implements ICalculableFactory {
    @Override
    public Calculable create(Complex firstArg) {
        return new Calculator(firstArg);
    }
}
