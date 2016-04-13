package com.htest.service.impl;

import com.htest.model.AppUser;
import com.htest.service.AppUserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tomasz on 13.04.2016.
 */
@Service
public class AppUserServiceImpl implements AppUserService{

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void insertUser(AppUser appUser) {
        sessionFactory.getCurrentSession().save(appUser);
    }

    @Transactional
    public AppUser getUser(int id) {
        AppUser user = sessionFactory.getCurrentSession().get(AppUser.class, id);
        System.out.println(user);
        return user;
    }
}