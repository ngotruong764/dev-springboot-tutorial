package com.luv2code.aop_demo.dao;

import com.luv2code.aop_demo.entity.Account;

public interface IAccountDAO {
    void addAccount(Account account, boolean vipFlag);

    boolean doWork();
}
