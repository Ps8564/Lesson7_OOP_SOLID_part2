import java.util.Scanner;

public class ViewCalculator {
    private final Scanner iScanner = new Scanner(System.in);
    private ICalculableFactory calculableFactory;

    public ViewCalculator(ICalculableFactory calculableFactory) {
        this.calculableFactory = calculableFactory;
    }

    public void run() {
        while (true) {
            Complex firstArg = promptComplex("Первый аргумент ");
            Calculable calculator = calculableFactory.create(firstArg);
            while (true) {
                String cmd = prompt("Введите действие (+, *, :, -, =): ");
                if (cmd.equals("+")) {
                    Complex arg = promptComplex("Введите второй аргумент: ");
                    calculator.sum(arg);
                    continue;
                }
                if (cmd.equals("*")) {
                    Complex arg = promptComplex("Второй аргумент ");
                    calculator.multi(arg);
                    continue;
                }
                if (cmd.equals(":")) {
                    Complex arg = promptComplex("Введите второй аргумент: ");
                    calculator.div(arg);
                    continue;
                }
                if (cmd.equals("-")) {
                    Complex arg = promptComplex("Введите второй аргумент: ");
                    calculator.minus(arg);
                    continue;
                }
                if (cmd.equals("=")) {
                    System.out.printf("Результат %s\n", calculator.getResult());
                    break;
                }
            }
            break;
        }
    }

    public void task() {
        System.out.println("GeekBrains: Объектно-ориентированное программирование Java. Урок 7. ООП Дизайн и Solid ч.2\n" +
                "Создать проект калькулятора комплексных чисел (достаточно сделать сложение, умножение и деление).\n" +
                "Применить при создании программы архитектурные паттерны, добавить логирование калькулятора.\n" +
                "Соблюдать принципы SOLID, паттерны проектирования.\r\n");
    }

    public void end() {
        System.out.println("\r\nЗадание выполнил Шутылев П.В. согласно уроку 7. ООП Дизайн и Solid ч.2\n" +
                "Дата выполнения 21.09.2024");
    }

    private String prompt(String msg) {
        System.out.print(msg);
        return iScanner.nextLine();
    }

    private double promptDouble(String msg) {
        System.out.print(msg);
        return Double.parseDouble(iScanner.nextLine());
    }

    private Complex promptComplex(String msg) {
        System.out.println(msg);
        double inputRe = promptDouble("Введите вещественную часть: ");
        double inputIm = promptDouble("Введите мнимую часть: ");
        return new Complex(inputRe, inputIm);
    }
}