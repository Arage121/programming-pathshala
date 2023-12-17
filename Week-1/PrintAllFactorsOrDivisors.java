import java.util.*;
public class PrintAllFactorsOrDivisors { // factors of 'n' are symmetric about sqrt(N) - 1
    public static void main(String[] args) {
        System.out.println(factors(20));
    }

    public static List<Integer> factors(int n){ // O(sqrt(n))
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                if(i*i == n) list.add(i);
                else{
                    list.add(i);
                    list.add(n/i); // from the above 1 point
                }
            }
        }
        return list;
    }

    // if sqrt(n) is a perfect square, then the no. of divisors will be odd
    // otherwise if it's not a perfect square, then the no. of divisors will be even ( you can find the perfect square by using Math.sqrt func )
    // for e.g if n=20 then int val = Math.sqrt(20) will return 4.5 double value but we will get it in int type val, then it will get typecasted to 4
    // so we can check val*val == n or not simply
}
