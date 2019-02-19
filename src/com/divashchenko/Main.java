package com.divashchenko;


public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(getFiboNumber(i) + " ");
        }

        //Tree 1
        TreeNode treeNodeFirstRoot = new TreeNode(1);

        treeNodeFirstRoot.left = new TreeNode(3);
        treeNodeFirstRoot.right = new TreeNode(2);
        treeNodeFirstRoot.left.left = new TreeNode(5);

        //Tree 2
        TreeNode treeNodeSecondRoot = new TreeNode(2);

        treeNodeSecondRoot.left = new TreeNode(1);
        treeNodeSecondRoot.right = new TreeNode(3);
        treeNodeSecondRoot.left.right = new TreeNode(4);
        treeNodeSecondRoot.right.right = new TreeNode(7);

        System.out.println();
        System.out.println();

        BTreePrinter.printNode(treeNodeFirstRoot);

        System.out.println();

        BTreePrinter.printNode(treeNodeSecondRoot);

        System.out.println();

        BTreePrinter.printNode(mergeTrees(treeNodeFirstRoot, treeNodeSecondRoot));


        //Tree 3
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(3);

        TreeNode treeNode2 = new TreeNode(3);
        treeNode2.left = new TreeNode(3);
        treeNode2.right = new TreeNode(3);
        treeNode2.left.left = new TreeNode(523);
        treeNode2.right.right = new TreeNode(3);

        TreeNode treeNode3 = new TreeNode(1014);
        treeNode3.left = new TreeNode(3);
        treeNode3.right = new TreeNode(3);
        treeNode3.left.left = new TreeNode(5122);
        treeNode3.right.right = new TreeNode(8544);

        System.out.println(checkTree(treeNode));
        System.out.println(checkTree(treeNode2));
        System.out.println(checkTree(treeNode3));
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

    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
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

    private static boolean checkTree(TreeNode treeNode) {
        if (treeNode != null) {
            return checkTree(treeNode, treeNode.value);
        } else {
            return true;
        }
    }

    private static boolean checkTree(TreeNode treeNode, int key) {
        if (treeNode == null) {
            return true;
        }
        if (treeNode.value != key) {
            return false;
        }
        return checkTree(treeNode.left, key) && checkTree(treeNode.right, key);
    }
}
