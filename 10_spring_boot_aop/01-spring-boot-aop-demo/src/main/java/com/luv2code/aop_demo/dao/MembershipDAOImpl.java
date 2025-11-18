package com.luv2code.aop_demo.dao;

import org.springframework.stereotype.Service;

@Service
public class MembershipDAOImpl implements IMembershipDAO{

    @Override
    public void addSillyMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
    }
}
