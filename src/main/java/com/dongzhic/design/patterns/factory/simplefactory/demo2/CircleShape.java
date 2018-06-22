package com.dongzhic.design.patterns.factory.simplefactory.demo2;

/**
 * 圆形
 * @author dongzc
 * @date 2018/6/22 10:21
 */
public class CircleShape implements Shape{
    public CircleShape () {
        System.out.println("CircleShape create.");
    }

    public void draw() {
        System.out.println("draw:CircleShape");
    }
}
