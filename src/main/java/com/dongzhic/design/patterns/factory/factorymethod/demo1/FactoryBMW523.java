package com.dongzhic.design.patterns.factory.factorymethod.demo1;

/**
 * @author dongzc
 * @date 2018/6/21 15:09
 */
public class FactoryBMW523 implements FactoryBMW {

    public BMW523 createBMW() {
        return new BMW523();
    }
}
