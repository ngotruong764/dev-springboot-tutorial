package com.luv2code.aop_demo;

import com.luv2code.aop_demo.dao.IAccountDAO;
import com.luv2code.aop_demo.dao.IMembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(IAccountDAO theAccountDAO, IMembershipDAO theMembershipDAO) {
        return runner -> demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
    }

    public void demoTheBeforeAdvice(IAccountDAO theAccountDAO, IMembershipDAO theMembershipDAO) {
        // call the business method
        theAccountDAO.addAccount();

        // call the membership business method
        theMembershipDAO.addSillyMember();

    }

}
