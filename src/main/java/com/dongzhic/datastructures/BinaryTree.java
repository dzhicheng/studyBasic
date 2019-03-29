package com.dongzhic.datastructures;

/**
 * @author zhicheng
 *         10
 *      9       20
 *          15      35
 * 先序：10 9 20 15 35
 * 中序：9 10 15 20 35
 * 后序：9 15 35 20 10
 *
 */
public class BinaryTree {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(35);

        treeNode1.setLeftTreeNode(treeNode2);
        treeNode1.setRightTreeNode(treeNode3);
        treeNode3.setLeftTreeNode(treeNode4);
        treeNode3.setRightTreeNode(treeNode5);

        // 先序遍历
//        preTraverserBTree(treeNode1);
        // 中序遍历
//        midTraverserBTree(treeNode1);
        // 后序遍历
        postTraverserBTree(treeNode1);
    }

    /**
     * 先序遍历：根->左->右
     * @param treeNode 节点
     */
    public static void preTraverserBTree (TreeNode treeNode) {

        if (treeNode != null) {
            System.out.println(treeNode.getValue());
            preTraverserBTree(treeNode.getLeftTreeNode());
            preTraverserBTree(treeNode.getRightTreeNode());
        }

    }

    /**
     * 中序遍历：左->根->右
     * @param treeNode 节点
     */
    public static void midTraverserBTree (TreeNode treeNode) {
        if (treeNode != null) {
            midTraverserBTree(treeNode.getLeftTreeNode());
            System.out.println(treeNode.getValue());
            midTraverserBTree(treeNode.getRightTreeNode());
        }
    }

    /**
     * 后序遍历：左->右->根
     * @param treeNode 节点
     */
    public static void postTraverserBTree (TreeNode treeNode) {
        if (treeNode != null) {
            postTraverserBTree(treeNode.getLeftTreeNode());
            postTraverserBTree(treeNode.getRightTreeNode());
            System.out.println(treeNode.getValue());
        }
    }

    /**
     * 动态创建二叉查找树
     * @param treeRoot 根节点
     * @param value 值
     */
    public static void createTree (TreeRoot treeRoot, int value) {

        // 如果树根为空(第一次访问)，将第一个值作为根节点
        if (treeRoot == null) {
            TreeNode treeNode = new TreeNode(value);
            treeRoot.setTreeRoot(treeNode);
        } else {

            // 当前树根
            TreeNode tempTreeRoot = treeRoot.getTreeRoot();

            // 当前值大于根值，往右边走
            if (value > tempTreeRoot.getValue()) {

                //右边没有树根，那就直接插入
                if (tempTreeRoot.getRightTreeNode() == null) {
                    tempTreeRoot.setRightTreeNode(new TreeNode(value));
                    return;
                } else {
                    // 如果右边有树根，到右边的树根去
                    tempTreeRoot = tempTreeRoot.getRightTreeNode();
                }
            } else {

                //左没有树根，那就直接插入
                if (tempTreeRoot.getLeftTreeNode() == null) {
                    tempTreeRoot.setLeftTreeNode(new TreeNode(value));
                    return;
                } else {

                    tempTreeRoot = tempTreeRoot.getLeftTreeNode();
                }

            }
        }
    }
}
