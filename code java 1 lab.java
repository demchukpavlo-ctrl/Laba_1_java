import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n      ЗАВДАННЯ ВАРІАНТУ 4:");
            System.out.println("1. Завдання 1 (Обчислення виразу в 3 форматах)");
            System.out.println("2. Завдання 2 (Масив A(2n) та середня сума)");
            System.out.println("3. Завдання 3 (Матриця A(n,n) -> Вектор B(n))");
            System.out.println("4. Завдання 4 (Обробка тексту: вилучення першої літери)");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Введіть число!");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очищення буфера

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

    // ЗАВДАННЯ 1: Обчислення виразу
    public static void runTask1(Scanner scanner) {
        System.out.println("\n ЗАВДАННЯ 1 ");
        
        System.out.println("1) Вхідні дані: double, Результат: double");
        System.out.print("Введіть a (double): ");
        double a1 = scanner.nextDouble();
        System.out.print("Введіть b (double): ");
        double b1 = scanner.nextDouble();
        double denom1 = Math.pow(b1, 4) + Math.pow(a1, 3);
        if (denom1 == 0) {
            System.out.println("Помилка: Ділення на нуль!");
        } else {
            double res1 = (a1 * b1 - (a1 + b1) * (a1 - b1)) / denom1 + 5 * b1;
            System.out.println("Результат: " + res1);
        }

        System.out.println("\n2) Вхідні дані: int, Результат: double");
        System.out.print("Введіть a (int): ");
        int a2 = scanner.nextInt();
        System.out.print("Введіть b (int): ");
        int b2 = scanner.nextInt();
        double denom2 = Math.pow(b2, 4) + Math.pow(a2, 3);
        if (denom2 == 0) {
            System.out.println("Помилка: Ділення на нуль!");
        } else {
            double res2 = (double) (a2 * b2 - (a2 + b2) * (a2 - b2)) / denom2 + 5 * b2;
            System.out.println("Результат: " + res2);
        }

        System.out.println("\n3) Вхідні дані: double, Результат: int");
        System.out.print("Введіть a (double): ");
        double a3 = scanner.nextDouble();
        System.out.print("Введіть b (double): ");
        double b3 = scanner.nextDouble();
        double denom3 = Math.pow(b3, 4) + Math.pow(a3, 3);
        if (denom3 == 0) {
            System.out.println("Помилка: Ділення на нуль!");
        } else {
            int res3 = (int) ((a3 * b3 - (a3 + b3) * (a3 - b3)) / denom3 + 5 * b3);
            System.out.println("Результат: " + res3);
        }
    }

    // ЗАВДАННЯ 2: Обробка одномірного масиву
    public static void runTask2(Scanner scanner) {
        System.out.println("\n ЗАВДАННЯ 2 ");
        System.out.print("Введіть n (n <= 200, розмір масиву буде 2n): ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("n має бути більше 0.");
            return;
        }

        double[] A = new double[2 * n];
        System.out.println("Введіть " + (2 * n) + " елементів масиву:");
        for (int i = 0; i < 2 * n; i++) {
            System.out.print("A[" + (i + 1) + "] = ");
            A[i] = scanner.nextDouble();
        }

        double sumFirstHalf = 0;
        for (int i = 0; i < n; i++) {
            sumFirstHalf += A[i];
        }
        double averageFirstHalf = sumFirstHalf / n;
        System.out.println("Середнє арифметичне першої половини A(1)...A(n): " + averageFirstHalf);

        double sumSecondHalf = 0;
        int count = 0;
        for (int i = n; i < 2 * n; i++) {
            if (A[i] > averageFirstHalf) {
                sumSecondHalf += A[i];
                count++;
            }
        }

        System.out.println("Сума елементів другої половини A(n+1)...A(2n), що > " + averageFirstHalf + ": " + sumSecondHalf);
        System.out.println("Кількість таких елементів: " + count);
    }

    // ЗАВДАННЯ 3: Двовимірний масив
    public static void runTask3(Scanner scanner) {
        System.out.println("\n ЗАВДАННЯ 3 ");
        System.out.print("Введіть розмірність квадратної матриці n (n <= 20): ");
        int n = scanner.nextInt();

        double[][] A = new double[n][n];
        System.out.println("Введіть елементи матриці A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = scanner.nextDouble();
            }
        }

        double[] B = new double[n];
        for (int i = 0; i < n; i++) {
            double rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += A[i][j];
            }
            B[i] = rowSum / n;
        }

        System.out.println("\nПочаткова матриця A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%8.2f ", A[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nВектор B (середні значення елементів рядків):");
        for (int i = 0; i < n; i++) {
            System.out.printf("B[%d] = %.2f\n", i, B[i]);
        }
    }

    // ЗАВДАННЯ 4: Обробка рядків
    public static void runTask4(Scanner scanner) {
        System.out.println("\n ЗАВДАННЯ 4 ");
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

        System.out.println("\nОброблений текст (вилучено повторні входження першої літери):");
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