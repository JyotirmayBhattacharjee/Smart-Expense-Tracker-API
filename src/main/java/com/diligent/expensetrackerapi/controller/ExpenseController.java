package com.diligent.expensetrackerapi.controller;

import com.diligent.expensetrackerapi.model.Expense;
import com.diligent.expensetrackerapi.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<Expense> addExpense(@Valid @RequestBody Expense expense) {
        Expense savedExpense = expenseService.addExpense(expense);
        return ResponseEntity.ok(savedExpense);
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getExpenses(
            @RequestParam(required = false) String category) {

        if (category != null) {
            return ResponseEntity.ok(expenseService.getExpensesByCategory(category));
        }

        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping("/total")
    public ResponseEntity<Map<String, Object>> getTotalExpenses(
            @RequestParam(required = false) String category) {

        if (category != null) {
            return ResponseEntity.ok(
                    Map.of(
                            "category", category,
                            "total", expenseService.getTotalByCategory(category)
                    )
            );
        }

        return ResponseEntity.ok(
                Map.of(
                        "total", expenseService.getTotalExpenses()
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {

        boolean deleted = expenseService.deleteExpense(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}