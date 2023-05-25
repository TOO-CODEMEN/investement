package com.too_codemen.application.repository;

import com.too_codemen.application.model.Expenses;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ExpensesRepositoryImpl{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Expenses getExpensesById(Long id) {
        String sql = "SELECT * FROM expenses WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ExpensesRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    public List<Expenses> getAllExpenses() {
        String sql = "SELECT * FROM expenses";
        return jdbcTemplate.query(sql, new ExpensesRowMapper());
    }

    public Expenses addExpenses(Expenses expenses) {
        String sql1 = "INSERT INTO expenses (INN, industry, headcount, productionArea," +
                "productionSquare, plannedAreaOfConstruction, equipment, typeOfBuilding," +
                "squareOfBuilding, accountingServices, patent, others) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql1, expenses.getINN(), expenses.getIndustry(), expenses.getHeadcount(), expenses.getProductionArea(), expenses.getProductionSquare(),
                expenses.getPlannedAreaOfConstruction(), expenses.getEquipment(), expenses.getTypeOfBuilding(), expenses.getSquareOfBuilding(), expenses.getAccountingServices(),
                expenses.getPatent(), expenses.getOthers());
        return expenses;
    }

    @PostConstruct
    public void createExpensesTable() {
        jdbcTemplate.execute("CREATE TABLE expenses (\n" +
                "  id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "  INN INT,\n" +
                "  industry VARCHAR(255),\n" +
                "  headcount INT,\n" +
                "  productionArea VARCHAR(255),\n" +
                "  productionSquare INT,\n" +
                "  plannedAreaOfConstruction INT,\n" +
                "  equipment VARCHAR(255),\n" +
                "  typeOfBuilding VARCHAR(255),\n" +
                "  squareOfBuilding INT,\n" +
                "  accountingServices INT,\n" +
                "  patent INT,\n" +
                "  others INT\n" +
                ");\n");
    }

    private static class ExpensesRowMapper implements RowMapper<Expenses> {

        @Override
        public Expenses mapRow(ResultSet rs, int rowNum) throws SQLException {
            Expenses expenses = new Expenses();
            expenses.setId(rs.getLong("id"));
            expenses.setINN(rs.getInt("INN"));
            expenses.setIndustry(rs.getString("industry"));
            expenses.setHeadcount(rs.getInt("headcount"));
            expenses.setProductionArea(rs.getString("productionArea"));
            expenses.setProductionSquare(rs.getInt("productionSquare"));
            expenses.setPlannedAreaOfConstruction(rs.getInt("plannedAreaOfConstruction"));
            expenses.setEquipment(rs.getString("equipment"));
            expenses.setTypeOfBuilding(rs.getString("typeOfBuilding"));
            expenses.setSquareOfBuilding(rs.getInt("squareOfBuilding"));
            expenses.setAccountingServices(rs.getInt("accountingServices"));
            expenses.setPatent(rs.getInt("patent"));
            expenses.setOthers(rs.getInt("others"));
            return expenses;
        }
    }
}
