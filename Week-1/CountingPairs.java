public class CountingPairs { // using the concept of modular arithmetic rules
    // i.e. remainder of sum of no's = sum of remainder's modulo the number
    public static void main(String[] args) { // count the number of pairs in array whose sum is divisible by k
       int[] arr = { 2, 2, 1, 7, 5 };
        System.out.println(findPairCount(arr, 4));
    }

    public static int findPairCount(int[] arr, int k){
        int[] countOfRemainders = new int[k];
        int pairs = 0;
        for(int i=0;i<arr.length;i++){ // this countOfRemainders array will contain the 0 remainder count similarly all 0 to k-remainders count
            countOfRemainders[arr[i]%k]++;
        }
        pairs += countOfRemainders[0]*(countOfRemainders[0]-1)/2; // for 0 remainder it will have to pair with itself and for all other it will pair like 1&(k-1),
        // 2$(k-2) so when u have to find 2 pair in the same bucket we use n*(n-1)/2; n here is count of numbers that are having 0 remainder
        for(int i=1;i<=k/2-1;i++){ // we are only going till k/2-1 because for the middle we will check some conditions to pair and as we will pair 1 with k-1
            // that's why we only need to go till half way of count array
            pairs += countOfRemainders[i]*countOfRemainders[k-i];
        }
        if(k%2 == 0){ // if it's even then it will again make a remainder bucket like 0 which will have no pair to with then we use same method as for 0
            pairs += countOfRemainders[k/2]*(countOfRemainders[k/2]-1)/2;
        }else{ // otherwise we simply repeat the same process as k/2 will be paired with it's next element as we have come to the middle part
            pairs += countOfRemainders[k/2]*countOfRemainders[k/2+1];
        }
        return pairs;
    }
}
