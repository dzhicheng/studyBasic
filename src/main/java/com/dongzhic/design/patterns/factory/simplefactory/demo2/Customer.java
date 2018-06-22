package com.dongzhic.design.patterns.factory.simplefactory.demo2;

/**
 * @author dongzc
 * @date 2018/6/22 10:28
 */
public class Customer {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circleShape = shapeFactory.getShape("circle");
        circleShape.draw();

        Shape rectShape = shapeFactory.getShape("rect");
        rectShape.draw();

        Shape triangleShape = shapeFactory.getShape("triangle");
        triangleShape.draw();
    }
}
