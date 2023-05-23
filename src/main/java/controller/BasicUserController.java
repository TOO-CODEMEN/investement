package controller;

import lombok.AllArgsConstructor;
import model.Expenses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BasicUserController {

    @PostMapping("/expenses")
    public ResponseEntity<Expenses> addExpenses(){
        return null;
    }

    @GetMapping("/expenses")
    public Expenses getExpenses(){
        return null;
    }

    @PutMapping("/expenses")
    public Expenses updateExpenses(){
        return null;
    }

}
