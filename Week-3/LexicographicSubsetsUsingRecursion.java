public class LexicographicSubsetsUsingRecursion {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int n = arr.length;
        int[] aux = new int[n];
        lexico(aux, arr, 0, 0, n);
    }

    public static void lexico(int[] aux, int[] arr, int sz, int i, int n){
        for(int k=0;k<sz;k++){
            System.out.print(aux[k]+" ");
        }
        System.out.println();
        if(i == n) return;
        for(int j=i;j<n;j++){
            aux[sz] = arr[j];
            lexico(aux, arr, sz+1, j+1, n);
        }
    }
}
