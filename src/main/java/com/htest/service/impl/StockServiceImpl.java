package com.htest.service.impl;

import com.htest.model.HibernateUtil;
import com.htest.model.Stock;
import com.htest.model.StockDetail;
import com.htest.service.StockService;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Tomasz on 19.04.2016.
 */
@Service
public class StockServiceImpl implements StockService {

    @Transactional
    public void addStock(Stock stock, StockDetail stockDetail, Session session) {

        session.beginTransaction();
        stock.setStockDetail(stockDetail);
        stockDetail.setStock(stock);
        session.save(stock);
        session.getTransaction().commit();
        session.close();
    }

    @Transactional
    public Session openSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public String randomString() {
        SecureRandom random = new SecureRandom();
        String nextSessionId = new BigInteger(130, random).toString(32);
        return nextSessionId.substring(0, 6);
    }
}
