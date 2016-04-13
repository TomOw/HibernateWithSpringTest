package com.htest.service;

import com.htest.model.AppUser;

/**
 * Created by Tomasz on 13.04.2016.
 */

public interface AppUserService {

    void insertUser(AppUser appUser);

    AppUser getUser(int id);
}
