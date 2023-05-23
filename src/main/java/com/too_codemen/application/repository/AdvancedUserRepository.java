package com.too_codemen.application.repository;

import com.too_codemen.application.model.AdvancedUser;
import com.too_codemen.application.model.Expenses;

public interface AdvancedUserRepository {

AdvancedUser getAdvancedUserById(Long id);
AdvancedUser addAdvancedUser(AdvancedUser advancedUser);
AdvancedUser updateAdvancedUserById(Long id, AdvancedUser advancedUser);
AdvancedUser deleteAdvancedUserById(Long id);

}
