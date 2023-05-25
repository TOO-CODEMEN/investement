package com.too_codemen.application.service;

import com.too_codemen.application.model.AdvancedUser;
import com.too_codemen.application.repository.AdvancedUserRepository;
import com.too_codemen.application.repository.AdvancedUserRepositoryImpl;

public class AdvancedUserServiceImpl implements AdvancedUserService{
    private AdvancedUserRepositoryImpl advancedUserRepositoryImpl;

    @Override
    public AdvancedUser getAdvancedUserById(Long id) {
        return advancedUserRepositoryImpl.getAdvancedUserById(id);
    }

    @Override
    public AdvancedUser addAdvancedUser(AdvancedUser advancedUser) {
        return advancedUserRepositoryImpl.addAdvancedUser(advancedUser);
    }

    @Override
    public AdvancedUser updateAdvancedUserById(Long id, AdvancedUser advancedUser) {
        return advancedUserRepositoryImpl.updateAdvancedUserById(id, advancedUser);
    }

    @Override
    public AdvancedUser deleteAdvancedUserById(Long id) {
        return advancedUserRepositoryImpl.deleteAdvancedUserById(id);
    }
}
