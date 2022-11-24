//Məsələ 3
//        Bu addımları et:
//
//        1. 1000 elementli massiv yaratmaq.
//
//        2. Massivin daxilini təsadüfi ədədlərlə doldurmaq.
//        (Təsadüfi ədədlərin seçim aralığı 1-dən 100-ə kimi olmalıdır).
//
//        3. Massivin daxilini təsadüfi ədədlərlə doldurduqdan sonra,
//        massivin daxilində hər ədəddən neçə ədəd olduğunu tapmaq.
//        Yəni, 1 ədədindən neçə dənə, 2 ədədindən neçə dənə, ... , 100 ədədindən
//        neçə dənə olmasını tapmaq.


import java.util.Random;

public class Task3 {

    public static void main(String[] args) {

        start();

    }

    public static void start() {

        Random random = new Random();

        int[] numbers = new int[1000];

        for (int i = 0; i < numbers.length; i++) {


            numbers[i] = (random.nextInt(100) + 1);

        }


        int count;
        for (int i = 1; i <= 100; i++) {
            count = 0;
            for (int number : numbers) {
                if (number == i) {
                    count++;
                }
            }

            System.out.printf("Ədəd: %s, sayısı:%s%n", i, count);

        }

    }


}
