package com.diligent.expensetrackerapi;

import com.diligent.expensetrackerapi.model.Expense;
import com.diligent.expensetrackerapi.service.ExpenseService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseServiceTest {

    private ExpenseService expenseService;

    @BeforeEach
    void setUp() {
        expenseService = new ExpenseService();
    }

    @Test
    void shouldAddExpense() {

        Expense expense = new Expense(
                null,
                "Food",
                500.0,
                "Food",
                LocalDate.now()
        );

        Expense saved = expenseService.addExpense(expense);

        assertNotNull(saved.getId());
        assertEquals("Food", saved.getTitle());
    }

    @Test
    void shouldReturnAllExpenses() {

        expenseService.addExpense(
                new Expense(null,"Food",500.0,"Food",LocalDate.now())
        );

        expenseService.addExpense(
                new Expense(null,"Fuel",1000.0,"Travel",LocalDate.now())
        );

        assertEquals(2, expenseService.getAllExpenses().size());

    }

    @Test
    void shouldCalculateTotalExpense() {

        expenseService.addExpense(
                new Expense(null,"Food",500.0,"Food",LocalDate.now())
        );

        expenseService.addExpense(
                new Expense(null,"Fuel",1000.0,"Travel",LocalDate.now())
        );

        assertEquals(1500.0,
                expenseService.getTotalExpenses());

    }

    @Test
    void shouldDeleteExpense() {

        Expense expense = expenseService.addExpense(
                new Expense(
                        null,
                        "Food",
                        500.0,
                        "Food",
                        LocalDate.now())
        );

        boolean deleted =
                expenseService.deleteExpense(expense.getId());

        assertTrue(deleted);

    }

}