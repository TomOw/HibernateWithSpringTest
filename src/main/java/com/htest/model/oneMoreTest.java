package com.htest.model;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Tomasz on 21.04.2016.
 */
public class oneMoreTest {

    public static void main(String[] args) throws IOException {

        Stock stock = new Stock("123", "name");
        StockDetail detail = new StockDetail(stock, "compnaem", "compDesc", "remark", new Date());
        stock.setStockDetail(detail);

        System.out.println(detail.giveListAsArrayList());

    }
}
