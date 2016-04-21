package com.htest.service;

import com.htest.model.Stock;
import com.htest.model.StockDetail;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomasz on 19.04.2016.
 */
@Service
public interface StockService {

    void addStock(Stock stock, StockDetail stockDetail);

    Session openSession();

    String randomString();

    void setSessionFactory();

    Stock getStock(int id);

    List getStockByName(String name);

}
