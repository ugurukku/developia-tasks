//Məsələ 4
//Verilmiş istənilən cümlənin daxilində
//        ən çox istifadə olunan simvolu tapan proqram yazmaq.
//
//        Qeyd:
//        Yazdığın proqram istənilən cümlənin daxilində
//        olan ən çox istifadə olunan simvolun sayınıda
//        həmçinin tapmalıdır və bu məlumatları konsolda göstərməlidir.

import java.util.HashMap;
import java.util.Map;

public class Task4 {

    public static void main(String[] args) {
        String sentence = "Ugur salam necesen bu gun dersler ela gedir bil ki bu usaqlar silib supurur";

        HashMap<Character,Integer> myHashMap = fillingHashMap(sentence);

        Map.Entry<Character,Integer> mostUsedChar = printMostUsedChar(myHashMap);

        System.out.printf(
                "Char ' %s ' ən çox istifadə olunan char - dır və %s dəfə istifadə olunmuşdur."
                ,mostUsedChar.getKey()
                ,mostUsedChar.getValue());
    }

    public static HashMap<Character,Integer> fillingHashMap(String sentence) {


        char[] chars = sentence.replaceAll(" ", "").toCharArray();

        HashMap<Character, Integer> charsMap = new HashMap<>();

        int count;

        for (int i = 0; i < chars.length - 1; i++) {

            if (!charsMap.containsKey(chars[i])) {
                count = 1;
                for (int j = i + 1; j < chars.length; j++) {

                    if (chars[i] == chars[j])
                        count++;

                }
                charsMap.put(chars[i], count);
            }
        }

        return charsMap;

    }

    public static Map.Entry<Character,Integer> printMostUsedChar(HashMap<Character,Integer> myHashMap){
                return
                myHashMap
                        .entrySet()
                        .stream()
                        .max(
                                (entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                        .get();

    }

}


