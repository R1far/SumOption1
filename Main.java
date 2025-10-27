public class Main {
    public static void main(String[] args) {
        int[] arr = new int[1000];

        for (int i = 0; i < 1000; i++) {
            arr[i] = (int)(Math.random() * 10001);
        }

        // Переменные для хранения максимальных элементов
        int maxDiv14_1 = -1;
        int maxDiv14_2 = -1;
        int maxDiv7_1 = -1;
        int maxDiv7_2 = -1;
        int maxDiv2_1 = -1;
        int maxDiv2_2 = -1;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            // Собираем два максимальных числа, кратных 14
            if (num % 14 == 0) {
                if (num > maxDiv14_1) {
                    maxDiv14_2 = maxDiv14_1;
                    maxDiv14_1 = num;
                } else if (num > maxDiv14_2) {
                    maxDiv14_2 = num;
                }
            }

            // Собираем два максимальных числа, кратных 7
            if (num % 7 == 0) {
                if (num > maxDiv7_1) {
                    maxDiv7_2 = maxDiv7_1;
                    maxDiv7_1 = num;
                } else if (num > maxDiv7_2) {
                    maxDiv7_2 = num;
                }
            }

            // Собираем два максимальных четных числа
            if (num % 2 == 0) {
                if (num > maxDiv2_1) {
                    maxDiv2_2 = maxDiv2_1;
                    maxDiv2_1 = num;
                } else if (num > maxDiv2_2) {
                    maxDiv2_2 = num;
                }
            }
        }

        long maxR = -1;

        // 14 × любое = кратно 14
        if (maxDiv14_1 > 0 && maxDiv14_2 > 0) {
            maxR = Math.max(maxR, (long)maxDiv14_1 * maxDiv14_2);
        }
        if (maxDiv14_1 > 0 && maxDiv2_1 > 0 && maxDiv14_1 != maxDiv2_1) {
            maxR = Math.max(maxR, (long)maxDiv14_1 * maxDiv2_1);
        }

        // 7 × четное = кратно 14
        if (maxDiv7_1 > 0 && maxDiv2_1 > 0 && maxDiv7_1 != maxDiv2_1) {
            maxR = Math.max(maxR, (long)maxDiv7_1 * maxDiv2_1);
        }
        if (maxDiv7_1 > 0 && maxDiv2_2 > 0 && maxDiv7_1 != maxDiv2_2) {
            maxR = Math.max(maxR, (long)maxDiv7_1 * maxDiv2_2);
        }
        if (maxDiv7_2 > 0 && maxDiv2_1 > 0 && maxDiv7_2 != maxDiv2_1) {
            maxR = Math.max(maxR, (long)maxDiv7_2 * maxDiv2_1);
        }

        System.out.println(maxR);
        System.out.println("Проверка кратности 14: " + (maxR % 14 == 0));
    }
}
