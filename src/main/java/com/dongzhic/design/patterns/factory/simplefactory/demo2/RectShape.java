package com.dongzhic.design.patterns.factory.simplefactory.demo2;

/**
 * 正方形
 * @author dongzc
 * @date 2018/6/22 10:21
 */
public class RectShape implements Shape{
    public RectShape () {
        System.out.println("RectShape create.");
    }

    public void draw() {
        System.out.println("draw: RectShape");
    }
}
