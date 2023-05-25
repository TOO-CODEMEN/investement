package com.too_codemen.application.repository;

import com.too_codemen.application.model.AdvancedUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class AdvancedUserRepositoryImpl{
//
//    private final SessionFactory sessionFactory;
//
//    public AdvancedUserRepositoryImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    public AdvancedUser getAdvancedUserById(Long id) {
//        Session session = sessionFactory.openSession();
//        AdvancedUser advancedUser = session.get(AdvancedUser.class, id);
//        session.close();
//        return advancedUser;
//    }
//
//    @Override
//    public AdvancedUser addAdvancedUser(AdvancedUser advancedUser) {
//        Session session = sessionFactory.openSession();
//        session.save(advancedUser);
//        session.close();
//        return advancedUser;
//    }
//
//    @Override
//    public AdvancedUser updateAdvancedUserById(Long id, AdvancedUser advancedUser) {
//        Session session = sessionFactory.openSession();
//        AdvancedUser existingUser = session.get(AdvancedUser.class, id);
//        if (existingUser != null) {
//            existingUser.setName(advancedUser.getName());
//            existingUser.setSurname(advancedUser.getSurname());
//            existingUser.setPatronymic(advancedUser.getPatronymic());
//            existingUser.setEmail(advancedUser.getEmail());
//            existingUser.setOrgName(advancedUser.getOrgName());
//            existingUser.setINN(advancedUser.getINN());
//            existingUser.setWebSiteUrl(advancedUser.getWebSiteUrl());
//            existingUser.setIndustry(advancedUser.getIndustry());
//            existingUser.setCountry(advancedUser.getCountry());
//            existingUser.setCity(advancedUser.getCity());
//            existingUser.setPosition(advancedUser.getPosition());
//            session.update(existingUser);
//        }
//        session.close();
//        return existingUser;
//    }
//
//    @Override
//    public AdvancedUser deleteAdvancedUserById(Long id) {
//        Session session = sessionFactory.openSession();
//        AdvancedUser advancedUser = session.get(AdvancedUser.class, id);
//        if (advancedUser != null) {
//            session.delete(advancedUser);
//        }
//        session.close();
//        return advancedUser;
//    }
}
