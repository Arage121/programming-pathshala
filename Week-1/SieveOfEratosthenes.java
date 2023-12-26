import java.util.*;
public class SieveOfEratosthenes {// finding all prime no's from 1 to N
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        boolean[] composites = new boolean[arr.length];
        System.out.println(primeOneToN(arr, composites));
    }
    public static List<Integer> primeOneToN(int[] arr, boolean[] composites){ // O(Nlog(logN)) time complexity
        List<Integer> list = new ArrayList<>();
        int n = (int)Math.sqrt(arr.length); // as we will take limit to sqrt(n) because all the primes no's after sqrt(n) don't require to mark their composites
        // as they have been already marked by the previous primes
        for(int i=2;i<=n;i++){
            if(composites[i] == false){
                // mark all the factors of i to true so that all it's composites will become true and false will be all the primes
                for(int j=i*i;j<arr.length;j+=i){ // here j+=i is also because we need mark all the factors to true(composites they are)
                    // it will start from i*i as we don't need to mark the repeated ones ( you can see this pattern by solving some examples)
                    composites[j] = true;
                }
            }
        }
        // all the primes are at position where composites[i] is false and the true are composites
        for(int i=2;i<arr.length;i++){
            if(composites[i] == false) list.add(i);
        }
        return list;
    }
}
