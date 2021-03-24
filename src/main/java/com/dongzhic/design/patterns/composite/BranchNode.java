package com.dongzhic.design.patterns.composite;


import java.util.ArrayList;
import java.util.List;

/**
 * 分支节点
 * @Author dongzhic
 * @Date 3/20/21 4:19 PM
 */
public class BranchNode extends Node {

    List<Node> nodes = new ArrayList<>();

    private String name;

    public BranchNode (String name) {
        this.name = name;
    }

    public void add (Node n) {
        nodes.add(n);
    }

    @Override
    public void p() {
        System.out.println(name);
    }
}
