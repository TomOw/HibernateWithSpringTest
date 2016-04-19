package com.htest.model;

import org.hibernate.Session;

import java.util.Date;


public class test {
    public static void main(String[] args) {

        System.out.println("Hibernate one to one (Annotation)");

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Stock stock = new Stock();
        StockDetail stockDetail = new StockDetail();

        stock.setStockCode("2");
        stock.setStockName("PAD12INIAASFwdsgasd");

        stockDetail.setCompName("PAD12I3NIA Hasdfolding Malaysia");
        stockDetail.setCompDesc("one sto123p shoasfApasdfpingA");
        stockDetail.setRemark("vinci vasfAi123nciasdfaA");
        stockDetail.setListedDate(new Date());

        stock.setStockDetail(stockDetail);
        stockDetail.setStock(stock);

        session.save(stock);
        session.getTransaction().commit();

        System.out.println("Done");
    }
}
