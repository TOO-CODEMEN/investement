package com.too_codemen.application.repository;

import com.too_codemen.application.model.Expenses;
import com.too_codemen.application.repository.ExpensesRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class ExpensesRepositoryImpl implements ExpensesRepository {
    private SessionFactory sessionFactory;

    public ExpensesRepositoryImpl() {
        // Инициализация и конфигурация sessionFactory
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public Expenses getExpensesById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Expenses expenses = session.get(Expenses.class, id);

        transaction.commit();
        session.close();

        return expenses;
    }

    @Override
    public Expenses addExpenses(Expenses expenses) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(expenses);

        transaction.commit();
        session.close();

        return expenses;
    }

    @Override
    public Expenses updateExpensesById(Long id, Expenses expenses) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Expenses existingExpenses = session.get(Expenses.class, id);
        if (existingExpenses != null) {
            existingExpenses.setINN(expenses.getINN());
            existingExpenses.setIndustry(expenses.getIndustry());
            existingExpenses.setHeadcount(expenses.getHeadcount());
            existingExpenses.setProductionArea(expenses.getProductionArea());
            existingExpenses.setProductionSquare(expenses.getProductionSquare());
            existingExpenses.setPlannedAreaOfConstruction(expenses.getPlannedAreaOfConstruction());
            existingExpenses.setEquipment(expenses.getEquipment());
            existingExpenses.setTypeOfBuilding(expenses.getTypeOfBuilding());
            existingExpenses.setSquareOfBuilding(expenses.getSquareOfBuilding());
            existingExpenses.setAccountingServices(expenses.getAccountingServices());
            existingExpenses.setPatent(expenses.getPatent());
            existingExpenses.setOthers(expenses.getOthers());
            existingExpenses.setAdvancedUserId(expenses.getAdvancedUserId());

            session.update(existingExpenses);
        }

        transaction.commit();
        session.close();

        return existingExpenses;
    }

    @Override
    public Expenses deleteExpensesById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Expenses expenses = session.get(Expenses.class, id);
        if (expenses != null) {
            session.delete(expenses);
        }

        transaction.commit();
        session.close();

        return expenses;
    }
}
