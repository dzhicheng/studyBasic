package com.dongzhic.design.patterns.factory.simplefactory.demo2;

/**
 * 三角形
 * @author dongzc
 * @date 2018/6/22 10:21
 */
public class TriangleShape implements Shape{
    public TriangleShape () {
        System.out.println("TriangleShape create.");
    }

    public void draw() {
        System.out.println("draw: TriangleShape");
    }
}
