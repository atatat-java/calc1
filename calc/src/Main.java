package MainEd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        String[] str = input.split(" ");
        if (str.length < 3) {
            throw new Exception("Строка не является математической операцией.");
        }
        if (str.length > 3 || Integer.parseInt(str[0]) < 1 || Integer.parseInt(str[0]) > 10 || Integer.parseInt(str[2]) < 1 || Integer.parseInt(str[2]) > 10) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда (от 1 до 10) и один оператор (+, -, /, *).");
        }
        if (!str[1].equals("+") && !str[1].equals("-") && !str[1].equals("*") && !str[1].equals("/")) {
            throw new Exception("Некорректный оператор.");
        }
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[2]);

        return switch (str[1]) {
            case "+" -> String.valueOf(a + b);
            case "-" -> String.valueOf(a - b);
            case "*" -> String.valueOf(a * b);
            case "/" -> String.valueOf(a / b);
            default -> null;
        };
    }
}
