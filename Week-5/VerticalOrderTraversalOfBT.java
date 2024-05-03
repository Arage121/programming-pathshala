//https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
import java.util.*;
public class VerticalOrderTraversalOfBT {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    static class Pair{
        Node node;
        int hd;
        public Pair(Node node, int hd){
            this.node = node;
            this.hd = hd; // horizontal distance
        }
    }
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root) // another approach
    {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        q.offer(new Pair(root, 0));
        int maxHd = Integer.MIN_VALUE;
        int minHd = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            Pair p = q.peek();
            q.poll();
            maxHd = Math.max(maxHd, p.hd);
            minHd = Math.min(minHd, p.hd);
            if(!map.containsKey(p.hd)) map.put(p.hd, new ArrayList<>());
            map.get(p.hd).add(p.node.data);

            if(p.node.left != null) q.offer(new Pair(p.node.left, p.hd-1));
            if(p.node.right != null) q.offer(new Pair(p.node.right, p.hd+1));
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=minHd;i<=maxHd;i++){
            List<Integer> temp = map.get(i);
            for(Integer a : temp){
                result.add(a);
            }
        }
        return result;
    }

//    static class Temp{ // 1st approach
//        int val;
//        int lvl; // level of a node in binary tree
//        int hd; // horizontal distance from root as origin
//        public Temp(int val, int lvl, int hd){
//            this.val = val;
//            this.lvl = lvl;
//            this.hd = hd;
//        }
//    }
//    static class tempComparator implements Comparator<Temp>{
//        @Override
//        public int compare(Temp t1, Temp t2){
//            if(t1.hd != t2.hd) return Integer.compare(t1.hd, t2.hd);
//            return Integer.compare(t1.lvl, t2.lvl);
//        }
//    }
//    //Function to find the vertical order traversal of Binary Tree.
//    static ArrayList <Integer> verticalOrder(Node root)
//    {
//        List<Temp> list = new ArrayList<>();
//        populate(list, root, 0, 0);
//        Collections.sort(list, new tempComparator());
//
//        ArrayList<Integer> result = new ArrayList<>();
//        for(Temp t: list){
//            result.add(t.val);
//        }
//
//        return result;
//    }
//
//    static void populate(List<Temp> list, Node root, int l, int h){
//        if(root == null) return;
//        list.add(new Temp(root.data, l, h));
//        populate(list, root.left, l+1, h-1);
//        populate(list, root.right, l+1, h+1);
//    }
}
