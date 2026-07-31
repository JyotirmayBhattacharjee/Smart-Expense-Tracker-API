package com.diligent.expensetrackerapi.service;

import com.diligent.expensetrackerapi.model.Expense;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ExpenseService {

    private final List<Expense> expenses = new ArrayList<>();

    private final AtomicLong idGenerator = new AtomicLong(1);

    public Expense addExpense(Expense expense) {

        expense.setId(idGenerator.getAndIncrement());

        expenses.add(expense);

        return expense;
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public List<Expense> getExpensesByCategory(String category) {

        List<Expense> result = new ArrayList<>();

        for (Expense expense : expenses) {

            if (expense.getCategory().equalsIgnoreCase(category)) {
                result.add(expense);
            }

        }

        return result;
    }

    public double getTotalExpenses() {

        double total = 0;

        for (Expense expense : expenses) {

            total += expense.getAmount();

        }

        return total;
    }

    public double getTotalByCategory(String category) {

        double total = 0;

        for (Expense expense : expenses) {

            if (expense.getCategory().equalsIgnoreCase(category)) {

                total += expense.getAmount();

            }

        }

        return total;
    }

    public boolean deleteExpense(Long id) {

        return expenses.removeIf(expense -> expense.getId().equals(id));

    }

}