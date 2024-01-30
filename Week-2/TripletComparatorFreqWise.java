import java.util.*;

public class TripletComparatorFreqWise {
    public static class Triplet {
        int val;
        int freq;
        int idx;
        public Triplet(int val, int freq, int idx){
            this.val = val;
            this.freq = freq;
            this.idx = idx;
        }
    }
    // values of arr can be from 0 to 100
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 5, 2 };
        int[] freq = new int[101];

        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }

        List<Triplet> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(new Triplet(arr[i], freq[arr[i]], i));
        }

        Comparator<Triplet> cmp = new Comparator<>(){
            public int compare(Triplet t1, Triplet t2){
                if(t1.freq != t2.freq) return Integer.compare(t1.freq, t2.freq);
                if(t1.val != t2.val) return Integer.compare(t1.val, t2.val);
                return Integer.compare(t1.idx, t2.idx);
            }
        };

        Collections.sort(list, cmp);

        for(int i=0;i<list.size();i++){
            arr[i] = list.get(i).val;
        }
        System.out.println(Arrays.toString(arr));
    }
}
