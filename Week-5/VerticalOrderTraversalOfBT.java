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
    static class Temp{
        int val;
        int lvl; // level of a node in binary tree
        int hd; // horizontal distance from root as origin
        public Temp(int val, int lvl, int hd){
            this.val = val;
            this.lvl = lvl;
            this.hd = hd;
        }
    }
    static class tempComparator implements Comparator<Temp>{
        @Override
        public int compare(Temp t1, Temp t2){
            if(t1.hd != t2.hd) return Integer.compare(t1.hd, t2.hd);
            return Integer.compare(t1.lvl, t2.lvl);
        }
    }
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        List<Temp> list = new ArrayList<>();
        populate(list, root, 0, 0);
        Collections.sort(list, new tempComparator());

        ArrayList<Integer> result = new ArrayList<>();
        for(Temp t: list){
            result.add(t.val);
        }

        return result;
    }

    static void populate(List<Temp> list, Node root, int l, int h){
        if(root == null) return;
        list.add(new Temp(root.data, l, h));
        populate(list, root.left, l+1, h-1);
        populate(list, root.right, l+1, h+1);
    }
}
