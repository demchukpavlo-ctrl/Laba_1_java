import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n      ЗАВДАННЯ:");
            System.out.println("1. Завдання 1 (Варіант 9: Обчислення виразу)");
            System.out.println("2. Завдання 2 (Варіант 10: Симетрична різниця масивів A і B)");
            System.out.println("3. Завдання 3 (Варіант 3: Перестановка max елемента в A[0][0])");
            System.out.println("4. Завдання 4 (Варіант 4: Обробка тексту)");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    runTask1(scanner);
                    break;
                case 2:
                    runTask2(scanner);
                    break;
                case 3:
                    runTask3(scanner);
                    break;
                case 4:
                    runTask4(scanner);
                    break;
                case 0:
                    System.out.println("Роботу завершено!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        }
    }

    // ЗАВДАННЯ 1 (Варіант 9)
    public static void runTask1(Scanner scanner) {
        System.out.println("\n--- ЗАВДАННЯ 1 (Варіант 9) ---");
        
        System.out.println("1) Вхідні дані: double, Результат: double");
        System.out.print("Введіть n (double): ");
        double n1 = scanner.nextDouble();
        System.out.print("Введіть m (double): ");
        double m1 = scanner.nextDouble();
        double res1 = ((n1 + 1) * (m1 - 4) + n1 * m1 - Math.pow(n1, 4) + Math.pow(m1, 3)) / Math.pow(m1 + 2, 2);
        System.out.println("Результат: " + res1);

        System.out.println("\n2) Вхідні дані: int, Результат: double");
        System.out.print("Введіть n (int): ");
        int n2 = scanner.nextInt();
        System.out.print("Введіть m (int): ");
        int m2 = scanner.nextInt();
        double res2 = (double) ((n2 + 1) * (m2 - 4) + n2 * m2 - Math.pow(n2, 4) + Math.pow(m2, 3)) / Math.pow(m2 + 2, 2);
        System.out.println("Результат: " + res2);

        System.out.println("\n3) Вхідні дані: double, Результат: int");
        System.out.print("Введіть n (double): ");
        double n3 = scanner.nextDouble();
        System.out.print("Введіть m (double): ");
        double m3 = scanner.nextDouble();
        int res3 = (int) (((n3 + 1) * (m3 - 4) + n3 * m3 - Math.pow(n3, 4) + Math.pow(m3, 3)) / Math.pow(m3 + 2, 2));
        System.out.println("Результат: " + res3);
    }

    // ЗАВДАННЯ 2 (Варіант 10)
    public static void runTask2(Scanner scanner) {
        System.out.println("\n--- ЗАВДАННЯ 2 (Варіант 10) ---");
        System.out.print("Введіть розмір масиву A (n <= 400): ");
        int n = scanner.nextInt();
        int[] A = new int[n];
        System.out.println("Введіть елементи масиву A:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        System.out.print("Введіть розмір масиву B (m <= 200): ");
        int m = scanner.nextInt();
        int[] B = new int[m];
        System.out.println("Введіть елементи масиву B:");
        for (int i = 0; i < m; i++) {
            B[i] = scanner.nextInt();
        }

        Set<Integer> setA = new HashSet<>();
        for (int val : A) setA.add(val);

        Set<Integer> setB = new HashSet<>();
        for (int val : B) setB.add(val);

        List<Integer> listC = new ArrayList<>();

        for (int val : setA) {
            if (!setB.contains(val)) {
                listC.add(val);
            }
        }
        for (int val : setB) {
            if (!setA.contains(val)) {
                listC.add(val);
            }
        }

        int[] C = new int[listC.size()];
        for (int i = 0; i < listC.size(); i++) {
            C[i] = listC.get(i);
        }

        System.out.println("\nСиметрична різниця (Масив C):");
        for (int val : C) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // ЗАВДАННЯ 3 (Варіант 3)
    public static void runTask3(Scanner scanner) {
        System.out.println("\n--- ЗАВДАННЯ 3 (Варіант 3) ---");
        System.out.print("Введіть розмірність квадратної матриці n (n <= 20): ");
        int n = scanner.nextInt();

        double[][] A = new double[n][n];
        System.out.println("Введіть елементи матриці A:");
        int maxRow = 0, maxCol = 0;
        double maxVal = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = scanner.nextDouble();
                if (A[i][j] > maxVal) {
                    maxVal = A[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        // Перестановка рядка maxRow з 0-м рядком
        if (maxRow != 0) {
            for (int j = 0; j < n; j++) {
                double temp = A[0][j];
                A[0][j] = A[maxRow][j];
                A[maxRow][j] = temp;
            }
        }

        // Перестановка стовпчика maxCol з 0-м стовпчиком
        if (maxCol != 0) {
            for (int i = 0; i < n; i++) {
                double temp = A[i][0];
                A[i][0] = A[i][maxCol];
                A[i][maxCol] = temp;
            }
        }

        System.out.println("\nПеретворена матриця A (максимальний елемент " + maxVal + " в A[0][0]):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%8.2f ", A[i][j]);
            }
            System.out.println();
        }
    }

    // ЗАВДАННЯ 4 (Варіант 4)
    public static void runTask4(Scanner scanner) {
        System.out.println("\n--- ЗАВДАННЯ 4 (Варіант 4) ---");
        System.out.println("Введіть текст:");
        String text = scanner.nextLine();

        StringBuilder result = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                currentWord.append(ch);
            } else {
                if (currentWord.length() > 0) {
                    result.append(processWord(currentWord.toString()));
                    currentWord.setLength(0);
                }
                result.append(ch);
            }
        }

        if (currentWord.length() > 0) {
            result.append(processWord(currentWord.toString()));
        }

        System.out.println("\nОброблений текст:");
        System.out.println(result.toString());
    }

    private static String processWord(String word) {
        if (word.isEmpty()) return word;

        char firstChar = word.charAt(0);
        char firstCharLower = Character.toLowerCase(firstChar);

        StringBuilder sb = new StringBuilder();
        sb.append(firstChar);

        for (int i = 1; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (Character.toLowerCase(currentChar) != firstCharLower) {
                sb.append(currentChar);
            }
        }

        return sb.toString();
    }
}