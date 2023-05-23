package controller;

import lombok.AllArgsConstructor;
import model.AdvancedUser;
import model.Expenses;

import service.AdvancedUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AdvancedUserController {

    @Autowired
    private final AdvancedUserService advancedUserService;

    @PostMapping("/registration")
    public ResponseEntity<AdvancedUser> addAdvancedUser(@RequestBody AdvancedUser advancedUser) {

        return null;
    }

    @PutMapping("/account")
    public ResponseEntity<AdvancedUser> updateAdvancedUser(@PathVariable Long id, @RequestBody AdvancedUser advancedUser) {
        return null;
    }

    @PostMapping("/expenses")
    public ResponseEntity<Expenses> addExpenses(@RequestBody Expenses advancedUser) {
        return null;
    }

    @GetMapping("/expenses")
    public Expenses getUserExpenses(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/expenses")
    public Expenses updateExpenses(@PathVariable Long id, @RequestBody Expenses expenses) {
        return null;
    }


}
