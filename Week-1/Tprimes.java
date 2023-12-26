//https://codeforces.com/problemset/problem/230/B
import java.util.*;
public class Tprimes { // the no's that are exactly divisible by 3 no's
    // so basically after solving some examples you will get to know that we only need to check that the sqrt of the number is prime or not, if it is
    // then it will have exactly 3 factors
//       Please try the following approach:
//       1. Note that a number will be t prime if it's square root is prime.
//       2. You need to precompute all the prime numbers till 1e6 before even taking the numbers as input.
//       3. Now for each number, you just need to check if it's square root exists and it's prime
    static final int N = (int)1e6 + 10;
    static boolean[] isPrime = new boolean[N + 1];

    static {
        Arrays.fill(isPrime, true);
    }

    static void sieve() {
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    static boolean isExactlyDivisibleBy3Factors(long x) {
        if (isPerfectSquare(x)) {
            long root = (long) Math.sqrt(x);
            return isPrime[(int) root];
        }
        return false;
    }

    static boolean isPerfectSquare(long n) {
        double sqrtN = Math.sqrt(n);
        return sqrtN == Math.floor(sqrtN);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        sieve();

        long number = scanner.nextLong();
        while(number-- > 0){
            long n = scanner.nextLong();
            if (isExactlyDivisibleBy3Factors(n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
