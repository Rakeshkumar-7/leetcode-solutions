//{ Driver Code Starts

import java.util.*;
import java.io.*;
class Node {
        int data;
        Node left, right;
 
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
class BinarySearchTree {
    public static Node root;
    BinarySearchTree() { 
        root = null; 
    }
    void insert(int key) {
       root = insertRec(root, key);
    }
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);
        return root;
    }
 
    public static void inorder()  {
       inorderRec(root);
    }
    public static void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data);
            inorderRec(root.right);
        }
    }
 
    // Driver Program to test above functions
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []a=new int[n];
            BinarySearchTree obj1=new BinarySearchTree();
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                obj1.insert(b);
            }
            //inorder();
            GFG obj=new GFG();
            boolean k=obj.isDeadEnd(root);
            if(k==true)
            System.out.println("1");
            else
            System.out.println("0");
        }       
    }
}


// } Driver Code Ends


/*class Node {
        int data;
        Node left, right;
 
        Node(int item) {
            data = item;
            left = right = null;
        }
    }*/

//Function should return true if a deadEnd is found in the bst otherwise return false.
class GFG
{
    private void DFS(Node root, Set<Integer> nodes, List<Integer> leaves){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            leaves.add(root.data);
        }
        
        nodes.add(root.data);
        DFS(root.left, nodes, leaves);
        DFS(root.right, nodes, leaves);
    }
    
    public static boolean isDeadEnd(Node root)
    {
        GFG ans = new GFG();
        Set<Integer> nodes = new HashSet<>();
        List<Integer> leaves = new LinkedList();
        nodes.add(0); // handle 1
        ans.DFS(root, nodes, leaves);
        // System.out.println(nodes);
        // System.out.println(leaves);
        for(int i: leaves){
            if(nodes.contains(i - 1) && nodes.contains(i + 1)){
                return true;
            }
        }
        
        return false;
    }
}