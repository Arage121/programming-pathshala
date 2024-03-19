//https://leetcode.com/problems/remove-duplicate-letters/
import java.util.*;
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        int[] freq = new int[26];
        boolean[] present = new boolean[26];

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        st.push(s.charAt(0));
        freq[s.charAt(0)-'a']--;
        present[s.charAt(0)-'a'] = true;

        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            freq[c-'a']--;
            if(present[c-'a']) continue;
            while(!st.isEmpty() && c < st.peek() && freq[st.peek()-'a'] > 0){
                present[st.peek()-'a'] = false;
                st.pop();
            }
            st.push(c);
            present[c-'a'] = true;
        }

        Stack<Character> reverseString = new Stack<>();

        while(!st.isEmpty()){
            reverseString.push(st.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!reverseString.isEmpty()){
            sb.append(reverseString.pop());
        }

        return sb.toString();
    }
}
