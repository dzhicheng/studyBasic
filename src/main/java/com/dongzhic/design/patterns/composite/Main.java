package com.dongzhic.design.patterns.composite;

/**
 * 组合模式
 * @Author dongzhic
 * @Date 3/20/21 4:22 PM
 */
public class Main {

    public static void main(String[] args) {

        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");
        LeftNode c11 = new LeftNode("c11");
        LeftNode c12 = new LeftNode("c12");
        BranchNode b21 = new BranchNode("b21");
        LeftNode c211 = new LeftNode("c211");
        LeftNode c212 = new LeftNode("c212");

        root.add(chapter1);
        root.add(chapter2);
        chapter1.add(c11);
        chapter1.add(c12);
        chapter2.add(b21);
        b21.add(c211);
        b21.add(c212);

        tree(root, 0);
    }

    /**
     *
     * @param b
     * @param depth 树的深度
     */
    public static void tree (Node b, int depth) {

        for (int i =0; i < depth; i ++) {
            System.out.print("--");
        }

        b.p();

        if (b instanceof BranchNode) {
           for (Node n : ((BranchNode)b).nodes ) {
               tree(n, depth+1);
           }
        }

    }
}
