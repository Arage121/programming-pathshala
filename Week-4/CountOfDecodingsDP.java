//https://leetcode.com/problems/decode-ways/
public class CountOfDecodingsDP {
    public int numDecodings(String s) { // using iterative way i.e (bottom-top dp)
        int first = 0;
        if(isValidCode(s.charAt(0)-'0', 1)) first = 1;
        if(s.length() == 1) return first;
        int second = 0;
        if(isValidCode(s.charAt(1)-'0', 1)) second += first;
        if(isValidCode((s.charAt(0)-'0')*10+(s.charAt(1)-'0'), 2)) second++;

        for(int i=2;i<s.length();i++){
            int curr = 0;
            if(isValidCode(s.charAt(i)-'0', 1)) curr += second;
            if(isValidCode((s.charAt(i-1)-'0')*10+(s.charAt(i)-'0'), 2)) curr += first;
            first = second;
            second = curr;
        }
        return second;
    }

    // public int numDecodings(String s) { // done recursion+memoization i.e (top-bottom dp)
    //     int[] ans = new int[s.length()];
    //     Arrays.fill(ans, -1);
    //     return countOfDecodings(s, ans, 0);
    // }

    // public int countOfDecodings(String s, int[] ans, int i){
    //     if(i >= s.length()) return 1;
    //     if(ans[i] != -1) return ans[i];
    //     ans[i] = 0;
    //     if(isValidCode(s.charAt(i)-'0', 1)){
    //         ans[i] += countOfDecodings(s, ans, i+1);
    //     }
    //     if(i<s.length()-1 && isValidCode((s.charAt(i)-'0')*10 + (s.charAt(i+1)-'0'), 2)){
    //         ans[i] += countOfDecodings(s, ans, i+2);
    //     }
    //     return ans[i];
    // }

    public boolean isValidCode(int code, int len){
        if(len == 1) return code >= 1 && code <= 9;
        return code >= 10 && code <= 26;
    }
}
