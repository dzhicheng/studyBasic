package com.dongzhic.java.ws.aio;

/**
 * Description:
 *
 * @author: dongzhic
 * @date: 2018/5/28 10:39
 */
public class AioMain {

    public static void main(String[] args) {
        //http://0.0.0.0:12307/chis/SaveAioService?wsdl
        String request = "{\"no\": \"20170505170147\",\"result\": \"体温高热，糖耐量降低\",\"unitName\": \"深圳市前海安测\",\"unitNo\": \"123456\",\"checkResult\": \"体温高热，糖耐量降低\",\"createTime\": \"2017-05-05 17:01:47\",\"dataLevel\": 0,\"dataType\": \"report\",\"id\": 406,\"idCard\": \"440106630807481\",\"macId\": \"12:34:56:78:93:21\",\"phone\": \"18033418779\",\"userId\": \"402880715702651701570409ad930000\",\"abnormal\": 0}";
        SaveAioServiceService aioServiceService = new SaveAioServiceService();
        SaveAioService aioService = aioServiceService.getSaveAioServicePort();
        aioService.execute(request);
    }
}
