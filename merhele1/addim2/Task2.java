//Məsələ 2
//        Verilmiş istənilən cümlənin daxilində olan sözlərin sayını tapan proqram yazmaq.
//        Cümlənin daxilində sözlərin arasında istifadə olunan ayırıcılar bunlar ola bilər.
//        -Boşluq
//        -Vergül
//        -Nöqtə

import java.util.HashMap;

public class Task2 {

    public static void main(String[] args) {
        printWordsAndCounts();
    }

    public static void printWordsAndCounts() {

        String sentence = "Uğur gəl gedək məktəbə Çünki müəllimə dedi ki məktəbə gəlin gəl gəl ";

        String[] words = sentence.toLowerCase().split(" ");

        HashMap<String, Integer> wordsMap = new HashMap<>();

        int count;

        for (int i = 0; i < words.length - 1; i++) {

            if (!wordsMap.containsKey(words[i])) {
                count = 1;

                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        count++;
                    }
                }

                wordsMap.put(words[i], count);
            }
        }

        wordsMap.forEach((word, wordCount) -> System.out.printf("%s : %s%n", word, wordCount));

    }

}
