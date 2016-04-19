package com.htest.controller;

import com.htest.model.Stock;
import com.htest.model.StockDetail;
import com.htest.service.StockService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by Tomasz on 13.04.2016.
 */
@Controller
public class Home {

    @Autowired
    StockService stockService;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }


    @RequestMapping(value = "/test")
    public String test() {
        Stock stock = new Stock(stockService.randomString(), stockService.randomString());
        StockDetail stockDetail = new StockDetail(stock, stockService.randomString(), stockService.randomString(), stockService.randomString(), new Date());
        Session session = stockService.openSession();
        stockService.addStock(stock, stockDetail, session);
        return "home";
    }
}
