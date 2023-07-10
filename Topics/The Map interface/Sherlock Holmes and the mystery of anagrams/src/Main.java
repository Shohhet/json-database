import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(isAnagram(str1, str2));
        // put your code here
    }

    private static String isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return "no";
        }
        return stringToMap(str1).equals(stringToMap(str2)) ? "yes" : "no";
    }

    public static  Map <Character, Integer> stringToMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : str.toLowerCase().toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }
        return map;

    }
}