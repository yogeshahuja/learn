import java.util.HashSet;


//Find the longest substring in a goven string without repeating any character

public class LongestSubstringWithoutRepeatCharacter {

    public static String findLongestSubString(String str){
        System.out.println("str is " + str);
        String longeStTillNow = "";
        String longestOverall = "";
        HashSet<Character> set = new HashSet<Character>();

        for(int i=0; i<=str.length()-1; i++) {
            if(set.contains(str.charAt(i))) {
                set.clear();
                longeStTillNow = "";
            } else {
                set.add(str.charAt(i));
                longeStTillNow = longeStTillNow + str.charAt(i);
                if (longeStTillNow.length() > longestOverall.length()) {
                    longestOverall = longeStTillNow;
                }
            }
        }

    return longestOverall;
    }

    public static void main(String[] args) {
        String input = "123456789stackoverflow";
        //System.out.println(subString(input));
        System.out.println("Substr is :" + findLongestSubString(input));

    }
}
