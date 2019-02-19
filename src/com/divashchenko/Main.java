package com.divashchenko;


public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(getFiboNumber(i) + " ");
        }

        //Tree 1
        Entry treeNodeFirstRoot = new Entry(1);

        treeNodeFirstRoot.left = new Entry(3);
        treeNodeFirstRoot.right = new Entry(2);
        treeNodeFirstRoot.left.left = new Entry(5);

        //Tree 2
        Entry treeNodeSecondRoot = new Entry(2);

        treeNodeSecondRoot.left = new Entry(1);
        treeNodeSecondRoot.right = new Entry(3);
        treeNodeSecondRoot.left.right = new Entry(4);
        treeNodeSecondRoot.right.right = new Entry(7);

        System.out.println();
        System.out.println();

        BTreePrinter.printNode(treeNodeFirstRoot);

        System.out.println();

        BTreePrinter.printNode(treeNodeSecondRoot);

        System.out.println();

        BTreePrinter.printNode(mergeTrees(treeNodeFirstRoot, treeNodeSecondRoot));
    }

    private static int getFiboNumber(int index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return getFiboNumber(index - 1) + getFiboNumber(index - 2);
        }
    }

    private static Entry mergeTrees(Entry t1, Entry t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        t1.value += t2.value;

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }
}
