package com.htest.controller;

import com.htest.model.Stock;
import com.htest.model.StockDetail;
import com.htest.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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
    public String test() throws IOException {
        Stock stock = new Stock(stockService.randomString(), stockService.randomString());
        StockDetail stockDetail = new StockDetail(stock, stockService.randomString(), stockService.randomString(), stockService.randomString(), new Date());
        stockService.setSessionFactory();
        stockService.addStock(stock, stockDetail);
        return "home";
    }

    @RequestMapping(value = "/get/{id}")
    public String getStock(Model model, @PathVariable("id") int id) {
        stockService.setSessionFactory();
        Stock stock = stockService.getStock(id);
        model.addAttribute("Stock", stock);
        return "home";
    }

    @RequestMapping(value = "/name/{s}")
    public String getByName(Model model, @PathVariable("s") String name) {
        stockService.setSessionFactory();
        List list = stockService.getStockByName(name);
        System.out.println("z controllera " + list.get(0));
        model.addAttribute("Stock", list.get(0));
        return "home";
    }
}
