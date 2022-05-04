package BinaryTree;

import BinaryNode.BinaryNode;

import java.util.Scanner;

public class BinarySearchTree {
    public BinaryNode root;
    static Scanner sc;
    public static BinaryNode create(){
        sc = new Scanner(System.in);
        BinaryNode root;
        System.out.println("Enter data: ");
        int data = sc.nextInt();
        if(data < 0) return null;
        root = new BinaryNode(data);
        System.out.println("Enter left for "+ data +" :");
        root.left = create();
        System.out.println("Enter right for "+data +" :");
        root.right = create();
        return root;
    }
    public void inOrder(BinaryNode root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public void preOrder(BinaryNode root){
        if(root==null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    public void postOrder(BinaryNode root){
        if(root == null)  return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
    public static BinaryNode insertRec(BinaryNode root,int data){
        if(root==null){
            root = new BinaryNode(data);
            return root;
        }
        if(root.data>data){
            root.left = insertRec(root.left,data);
        }
        else if(root.data<data){
            root.right = insertRec(root.right,data);
        }
        return root;
    }
    public void insert(int data){
        root =  insertRec(root,data);
    }

    public BinaryNode delete(BinaryNode root,int data){
        if(root==null){
            return root;
        }
        if(root.data<data){
            root.right = delete(root.right,data);
        }
        else if(root.data > data)
            root.left = delete(root.left,data);
        else {
            if(root.left == null && root.right==null)
                return null;
            else if(root.left == null)
                return root.right;
            return root.left;
        }
        return root;
    }
    public void implement(){
        sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("\n\n\t\t\tEnter your choice");
            System.out.println("\t\t\t1.Create tree.");
            System.out.println("\t\t\t2.Traverse using preorder.");
            System.out.println("\t\t\t3.Traverse using inorder.");
            System.out.println("\t\t\t4.Traverse using postorder.");
            System.out.println("\t\t\t5.Delete from tree");
            System.out.println("\t\t\t6.exit");
            int choice = sc.nextInt();
            BinaryNode root = null;
            switch (choice) {
                case 1 -> {
                    root = create();
                }
                case 2 -> {
                    preOrder(root);
                }
                case 3 -> {
                    inOrder(root);
                }
                case 4 -> {
                    postOrder(root);
                }
                case 5 -> {
                    System.out.println("\t\t\t Enter data you want to delete :");
                    delete(root, sc.nextInt());
                }
                case 6 -> flag = false;
                default -> {
                    System.out.println();
                    System.out.println("\t\t\t\t\tThank you for using our program.");
                }
            }
        }
    }
    public boolean path(BinaryNode root, int data){
        if(root==null){
            return false;
        }
        if(root.data == data){
            System.out.print(root.data);
            return true;
        }
        if(root.data<data){
            if(path(root.right,data)){
                System.out.print("<-"+root.data);
                return true;
            }
        }
        else {
            if(path(root.left,data)){
                System.out.print("<-"+root.data);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(15);
        tree.insert(9);
        tree.insert(30);
        tree.insert(25);
        tree.insert(12);
        tree.path(tree.root,25);
    }
}
