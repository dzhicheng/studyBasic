package com.dongzhic.design.patterns.factory.simplefactory.demo2;

/**
 * @author dongzc
 * @date 2018/6/22 10:24
 */
public class ShapeFactory {

    public Shape getShape (String type) {
        Shape shape = null;
        if (type.equalsIgnoreCase("circle")) {
            shape = new CircleShape();
        } else if (type.equalsIgnoreCase("rect")){
            shape = new RectShape();
        } else if (type.equalsIgnoreCase("triangle")){
            shape = new TriangleShape();
        }
        return shape;
    }

}
