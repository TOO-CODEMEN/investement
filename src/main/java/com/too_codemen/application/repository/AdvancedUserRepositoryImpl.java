package com.too_codemen.application.repository;

import com.too_codemen.application.model.AdvancedUser;
import com.too_codemen.application.repository.AdvancedUserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AdvancedUserRepositoryImpl implements AdvancedUserRepository {
    private SessionFactory sessionFactory;

    public AdvancedUserRepositoryImpl() {
        // Инициализация и конфигурация sessionFactory
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public AdvancedUser getAdvancedUserById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        AdvancedUser advancedUser = session.get(AdvancedUser.class, id);

        transaction.commit();
        session.close();

        return advancedUser;
    }

    @Override
    public AdvancedUser addAdvancedUser(AdvancedUser advancedUser) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(advancedUser);

        transaction.commit();
        session.close();

        return advancedUser;
    }

    @Override
    public AdvancedUser updateAdvancedUserById(Long id, AdvancedUser advancedUser) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        AdvancedUser existingUser = session.get(AdvancedUser.class, id);
        if (existingUser != null) {
            existingUser.setName(advancedUser.getName());
            existingUser.setSurname(advancedUser.getSurname());
            existingUser.setPatronymic(advancedUser.getPatronymic());
            existingUser.setEmail(advancedUser.getEmail());
            existingUser.setOrgName(advancedUser.getOrgName());
            existingUser.setINN(advancedUser.getINN());
            existingUser.setWebSiteUrl(advancedUser.getWebSiteUrl());
            existingUser.setIndustry(advancedUser.getIndustry());
            existingUser.setCountry(advancedUser.getCountry());
            existingUser.setCity(advancedUser.getCity());
            existingUser.setPosition(advancedUser.getPosition());

            session.update(existingUser);
        }

        transaction.commit();
        session.close();

        return existingUser;
    }

    @Override
    public AdvancedUser deleteAdvancedUserById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        AdvancedUser advancedUser = session.get(AdvancedUser.class, id);
        if (advancedUser != null) {
            session.delete(advancedUser);
        }

        transaction.commit();
        session.close();

        return advancedUser;
    }
}
