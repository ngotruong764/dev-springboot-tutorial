package com.luv2code.aop_demo.dao;

import com.luv2code.aop_demo.entity.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountDAOImpl implements IAccountDAO{

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
