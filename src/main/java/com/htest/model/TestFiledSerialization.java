package com.htest.model;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Tomasz on 21.04.2016.
 */
public class TestFiledSerialization {

    public static void main(String[] args) throws IOException {

        Stock stock = new Stock("123", "name");
        StockDetail detail = new StockDetail(stock, "compnaem", "compDesc", "remark", new Date());
        stock.setStockDetail(detail);

        ArrayList<String> strings = new ArrayList<String>();
        strings.add("first");
        strings.add("second");
        strings.add("third");
        strings.add("fourht");

        detail.setListArrayList(strings);

        System.out.println(Arrays.toString(stock.getStockDetail().getList()));

        System.out.println(stock.getStockDetail().giveListAsArrayList());

        byte[] bytes = detail.getList();
        System.out.println(Arrays.toString(bytes));

        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        DataInputStream in = new DataInputStream(bais);
        while (in.available() > 0) {
            String element = in.readUTF();
            System.out.println(element);
        }



    }
}
