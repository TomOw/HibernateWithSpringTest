package com.htest.service.impl;

import com.htest.model.HibernateUtil;
import com.htest.model.Stock;
import com.htest.model.StockDetail;
import com.htest.service.StockService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Tomasz on 19.04.2016.
 */
@Service
public class StockServiceImpl implements StockService {

    private SessionFactory sessionFactory;

    @Transactional
    public void addStock(Stock stock, StockDetail stockDetail) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        stock.setStockDetail(stockDetail);
        stockDetail.setStock(stock);
        session.save(stock);
        session.getTransaction().commit();
        System.out.println("_____________________________________________________________________________________________");
    }

    @Transactional
    public Session openSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public String randomString() {
        SecureRandom random = new SecureRandom();
        String nextSessionId = new BigInteger(130, random).toString(32);
        System.out.println(nextSessionId);
        return nextSessionId.substring(0, 6);
    }

    @Transactional
    public Stock getStock(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Stock stock = session.get(Stock.class, 42);
        session.getTransaction().commit();
        return stock;
    }

    public void setSessionFactory() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
}
