//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
import java.util.*;
public class LetterCombinations { // recursion ( principle )
    class Solution {

        private List<String> list = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            List<List<Character>> digitMap = new ArrayList<>();
            digitMap.add(List.of('a', 'b', 'c'));
            digitMap.add(List.of('d', 'e', 'f'));
            digitMap.add(List.of('g', 'h', 'i'));
            digitMap.add(List.of('j', 'k', 'l'));
            digitMap.add(List.of('m', 'n', 'o'));
            digitMap.add(List.of('p', 'q', 'r', 's'));
            digitMap.add(List.of('t', 'u', 'v'));
            digitMap.add(List.of('w', 'x', 'y', 'z'));
            if(digits.length() == 0) return new ArrayList<>();
            printAllCombo("", digits, 0, digitMap);
            return list;
        }

        public void printAllCombo(String p, String digits, int lvlOrIndex, List<List<Character>> digitMap){
            if(lvlOrIndex == digits.length()){
                list.add(p);
                return;
            }

            for(int j=0;j<digitMap.get(digits.charAt(lvlOrIndex) - '2').size();j++){
                printAllCombo(p+digitMap.get(digits.charAt(lvlOrIndex)-'2').get(j), digits, lvlOrIndex+1, digitMap);
            }
        }
    }
}
