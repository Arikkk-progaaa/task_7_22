import java.util.Scanner;

public class Main {
    public static int[] solution(int[] array){
        if (array.length == 0) return new int[]{-1, 0};

        int maxLength = 0;
        int maxStartIndex = -1;
        int currentStart = 0;
        int currentLength = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) currentLength++;
            else{
                if (currentLength >= maxLength){
                    maxStartIndex = currentStart;
                    maxLength = currentLength;
                }
                currentLength = 1;
                currentStart = i;
            }
        }

        if (currentLength >= maxLength){
            maxLength = currentLength;
            maxStartIndex = currentStart;
        }

        return new int[]{maxStartIndex, maxLength};
    }

    public static int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void runTests() {
        int[][] testCases = {
                {},
                {1},
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1},
                {1, 2, 3, 1, 2, 3, 4, 5},
                {1, 1, 1, 1, 1},
                {1, 2, 3, 3, 4, 5},
                {10, 20, 30, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 0, 1, 2, 3, 4, 5},
                {-3, -2, -1, 0, 1, 2},
        };
        System.out.println("Тесты:");
        for (int i = 0; i < testCases.length; i++) {
            System.out.print("Тест " + (i + 1) + ": Входной массив: ");
            printArray(testCases[i]);
            int[] result = solution(testCases[i]);
            int[] subsequence = extractSubsequence(testCases[i], result[0], result[1]);
            System.out.println("Результат: Начало: " + result[0] + ", Длина: " + result[1]);
            System.out.print("Последовательность: ");
            printArray(subsequence);
            System.out.println();
        }
    }

    public static int[] extractSubsequence(int[] array, int start, int length) {
        int[] subsequence = new int[length];
        for (int i = 0; i < length; i++) {
            subsequence[i] = array[start + i];
        }
        return subsequence;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        runTests();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Хотите ввести собственный массив? (да/нет): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("да") || answer.equalsIgnoreCase("д")) {
            int[] userArray = inputArray();
            System.out.print("Введенный массив: ");
            printArray(userArray);
            int[] result = solution(userArray);
            int[] subsequence = extractSubsequence(userArray, result[0], result[1]);
            System.out.println("Результат: Начало: " + result[0] + ", Длина: " + result[1]);
            System.out.print("Последовательность: ");
            printArray(subsequence);
        }
    }
}