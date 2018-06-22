package com.dongzhic.design.patterns.factory.simplefactory.demo1;

/**
 *  工厂类：生产宝马
 * @author dongzc
 * @date 2018/6/21 14:41
 */
public class Factory {

    public BMW createBMW (int type) {
        switch (type) {
            case 320 :
                return new BMW320();
            case 523 :
                return new BMW523();
            default:
                break;
        }
        return null;
    }
}
