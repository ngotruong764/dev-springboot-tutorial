package com.luv2code.aop_demo.dao;

import org.springframework.stereotype.Service;

@Service
public class MembershipDAOImpl implements IMembershipDAO{

    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": I'm going to sleep now....");
    }
}
