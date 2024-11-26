//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input:");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("Output: " + result);
        } catch (Exception e) {
            System.out.println("throws Exception // " + e);
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.trim().split(" ");
        if (parts.length != 3) {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        int num1;
        int num2;
        String operator = parts[1];

        try {
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Операнды должны быть целыми числами.");
        }

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Операнды должны находиться в диапазоне [1...10].");
        }

        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new Exception("Деление на ноль не допускается.");
                }
                result = num1 / num2;
                break;
            default:
                throw new Exception("Неверный оператор. Ожидается одно из: +, -, *, /");
        }

        return String.valueOf(result);
    }
}