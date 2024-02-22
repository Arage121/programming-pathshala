//https://leetcode.com/problems/generate-parentheses/
import java.util.*;
public class GenerateParenthesesRevisitingRecursion {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        func(result, n, 0, 0, "");
        return result;
    }

    public void func(List<String> result, int n, int l, int r, String p){ // l-left parantheses count r-right parentheses count
        if(l+r == 2*n){
            result.add(p);
            return;
        }

        if(l == r){
            func(result, n, l+1, r, p+"(");
        }else if(l > r){
            if(l == n){
                func(result, n, l, r+1, p+")");
            }else{
                func(result, n, l+1, r, p+"(");
                func(result, n, l, r+1, p+")");
            }
        }
    }
}
