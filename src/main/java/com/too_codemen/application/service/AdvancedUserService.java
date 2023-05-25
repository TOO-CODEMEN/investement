package com.too_codemen.application.service;

import com.too_codemen.application.model.AdvancedUser;
import com.too_codemen.application.repository.AdvancedUserRepositoryImpl;
import org.springframework.stereotype.Component;

@Component
public interface AdvancedUserService {
    AdvancedUser getAdvancedUserById(Long id);
    AdvancedUser addAdvancedUser(AdvancedUser advancedUser);
    AdvancedUser updateAdvancedUserById(Long id, AdvancedUser advancedUser);
    AdvancedUser deleteAdvancedUserById(Long id);
}
