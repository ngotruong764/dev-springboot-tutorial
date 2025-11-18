package com.luv2code.aop_demo.dao;

import org.springframework.stereotype.Service;

@Service
public class AccountDAOImpl implements IAccountDAO{

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
