//https://leetcode.com/problems/k-closest-points-to-origin/
import java.util.*;
class ComparatorsInJava {

    class Pair{
        int first, second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        List<Pair> list = new ArrayList<>();
        for(int i=0;i<points.length;i++){
            list.add(new Pair(points[i][0], points[i][1]));
        }

        Comparator<Pair> cmp = new Comparator<>(){
            public int compare(Pair p1, Pair p2){
                int d1 = (p1.first*p1.first)+(p1.second*p1.second);
                int d2 = (p2.first*p2.first)+(p2.second*p2.second);
                return Integer.compare(d1, d2);
            }
        };

        Collections.sort(list, cmp);

        int[][] ans = new int[k][2];

        for(int i=0;i<k;i++){
            ans[i][0] = list.get(i).first;
            ans[i][1] = list.get(i).second;
        }

        return ans;
    }
}