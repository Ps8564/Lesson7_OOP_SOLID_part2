public class LogCalculator implements Calculable {
    private final Calculable oldCalc;
    private final Loggable logger;

    public LogCalculator(Calculable oldCalc, Loggable logger) {
        this.oldCalc = oldCalc;
        this.logger = logger;
    }

    @Override
    public Calculable sum(Complex arg) {
        Complex firstArg = oldCalc.getResult();
        logger.log(String.format("Logger: Введеное значение калькулятора %s. Выполнение действия sum с параметром %s", firstArg, arg));
        Calculable result = oldCalc.sum(arg);
        logger.log("Вызов действия sum произошел.");
        return result;
    }

    @Override
    public Calculable multi(Complex arg) {
        Complex firstArg = oldCalc.getResult();
        logger.log(String.format("Logger: Введеное значение калькулятора %s. Выполнение действия multi с параметром %s", firstArg, arg));
        Calculable result = oldCalc.multi(arg);
        logger.log("Вызов действия multi произошел.");
        return result;
    }

    @Override
    public Calculable div(Complex arg) {
        try {
            Complex firstArg = oldCalc.getResult();
            logger.log(String.format("Logger: Введеное значение калькулятора %s. Начало вызова метода div с параметром %s", firstArg, arg));
            Calculable result = oldCalc.div(arg);
            logger.log("Вызов действия div произошел.");
            return result;
        } catch (ArithmeticException e) {
            logger.log("Ошибка: деление на ноль.");
            throw e;
        }
    }

    @Override
    public Calculable minus(Complex arg) {
        Complex firstArg = oldCalc.getResult();
        logger.log(String.format("Logger: Введеное значение калькулятора %s. Начало вызова метода minus с параметром %s", firstArg, arg));
        Calculable result = oldCalc.minus(arg);
        logger.log("Вызов действия minus произошел.");
        return result;
    }

    @Override
    public Complex getResult() {
        Complex result = oldCalc.getResult();
        logger.log(String.format("Получение результата %s", result));
        return result;
    }
}
