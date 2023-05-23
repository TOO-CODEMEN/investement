package com.too_codemen.application.controller;


import com.too_codemen.application.model.AdvancedUser;
import com.too_codemen.application.service.AdvancedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/advancedUsers")
public class AdvancedUserController {

    @Autowired
    private AdvancedUserService advancedUserService;

//    @Autowired
//    public AdvancedUserController(AdvancedUserService advancedUserService) {
//        this.advancedUserService = advancedUserService;
//    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvancedUser> getAdvancedUserById(@PathVariable("id") Long id) {
        AdvancedUser advancedUser = advancedUserService.getAdvancedUserById(id);
        if (advancedUser != null) {
            return ResponseEntity.ok(advancedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AdvancedUser> addAdvancedUser(@RequestBody AdvancedUser advancedUser) {
        AdvancedUser createdUser = advancedUserService.addAdvancedUser(advancedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdvancedUser> updateAdvancedUserById(
            @PathVariable("id") Long id,
            @RequestBody AdvancedUser advancedUser
    ) {
        AdvancedUser updatedUser = advancedUserService.updateAdvancedUserById(id, advancedUser);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvancedUserById(@PathVariable("id") Long id) {
        AdvancedUser deletedUser = advancedUserService.deleteAdvancedUserById(id);
        if (deletedUser != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

