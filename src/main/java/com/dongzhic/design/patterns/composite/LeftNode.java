package com.dongzhic.design.patterns.composite;

/**
 * 叶子节点
 * @Author dongzhic
 * @Date 3/20/21 4:17 PM
 */
public class LeftNode extends Node {

    private String content;

    public LeftNode (String content) {
        this.content = content;
    }

    @Override
    public void p() {
        System.out.println(content);
    }
}
