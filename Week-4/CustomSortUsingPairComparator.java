//https://leetcode.com/problems/custom-sort-string/
public class CustomSortUsingPairComparator { // pair is a custom defined data structure
    class Pair{
        char first;
        int second;
        Pair(char first, int second){
            this.first = first;
            this.second = second;
        }
    }

    class PairComparator implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            return p1.second - p2.second;
        }
    }

    public String customSortString(String order, String s) {
        int[] rank = new int[26];
        Arrays.fill(rank, Integer.MAX_VALUE);

        for(int i=0;i<order.length();i++){
            rank[order.charAt(i)-'a'] = i;
        }

        List<Pair> list = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            list.add(new Pair(s.charAt(i), rank[s.charAt(i)-'a']));
        }

        Collections.sort(list, new PairComparator());

        StringBuilder sb = new StringBuilder();

        for(Pair p : list){
            sb.append(p.first);
        }

        return sb.toString();
    }
}
