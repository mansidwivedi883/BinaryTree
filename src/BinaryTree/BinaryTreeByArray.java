package BinaryTree;

import BinaryNode.BinaryNode;

import java.util.Scanner;

public class BinaryTreeByArray {
    int[] arr;
    int lastIndex;

    public BinaryTreeByArray(int size) {
        arr = new int[size + 1];
        lastIndex = 0;
    }

    Scanner sc;

    public void insert(int value) {
        if (arr.length - 1 == lastIndex) {
            System.out.println("Tree is full");
        } else {
            arr[++lastIndex] = value;
        }
    }

    public void postOrder(int index) {
        if (index > lastIndex) return;
        postOrder(index * 2);
        postOrder(index * 2 + 1);
        System.out.println(arr[index]);
    }

    public void inOrder(int index) {
        if (index > lastIndex) return;
        inOrder(index * 2);
        System.out.println(arr[index]);
        inOrder(index * 2 + 1);
    }

    public void preOrder(int index) {
        if (index > lastIndex) return;
        System.out.println(arr[index]);
        preOrder(index * 2);
        preOrder(index * 2 + 1);
    }

    public boolean dfs(int value) {
        int i = 1;
        int leaf = 1;
        while (i < arr.length) {
            if (arr[i] == value)
                return true;
            if (i < arr.length / 2) {
                i = 2 * i + 1;
            } else {
                int k = 1;
                while (true) {
                    i = (i - 1) / 2;
                    int p = k * 2;
                    if (leaf % p == k - 1) break;
                    k = p;
                }
                i = 2 * i + 2;
                leaf++;
            }
        }
        return false;
    }

    public int bfs(int value) {
        for (int i = 0; i < arr.length; i++) {
            int t = arr[i];
            if (t == value)
                return i;
        }
        return -1;
    }

    public void delete(int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                if (2 * i < arr.length && 2 * i + 1 < arr.length)
                    arr[i] = Math.min(arr[2 * i], arr[2 * i + 1]);
                else if (2 * i < arr.length)
                    arr[i] = arr[2 * i];
                else if (2 * i + 1 < arr.length) {
                    arr[i] = arr[2 * i + 1];
                } else {
                    arr[i] = 0;
                }
            }
        }
    }

    public void implement() {
        boolean flag = true;
        while (flag) {
            sc = new Scanner(System.in);
            System.out.println("\n\n\t\t\tEnter your choice");
            System.out.println("\t\t\t1.Create tree or insert value.");
            System.out.println("\t\t\t2.Traverse using preorder.");
            System.out.println("\t\t\t3.Traverse using inorder.");
            System.out.println("\t\t\t4.Traverse using postorder.");
            System.out.println("\t\t\t5.Delete from tree");
            System.out.println("\t\t\t6.Exit");
            int choice = sc.nextInt();
            BinaryNode root = null;
            switch (choice) {
                case 1 -> {
                    System.out.println("\n\n\t\t\tInput value to insert:");
                    insert(sc.nextInt());
                }
                case 2 -> {
                    preOrder(1);
                }
                case 3 -> {
                    inOrder(1);
                }
                case 4 -> {
                    postOrder(1);
                }
                case 5 -> {
                    System.out.println("\t\t\t Enter data you want to delete :");
                    delete(sc.nextInt());
                }
                case 6 -> flag = false;
                default -> {
                    System.out.println();
                    System.out.println("\t\t\t\t\tThank you for using our program.");
                }
            }
        }
    }
}