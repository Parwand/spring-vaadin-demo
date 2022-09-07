package com.example.application.applicationservice.service;

import com.example.application.applicationservice.repository.UserGroupRepository;
import com.example.application.domain.model.UserGroup;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserGroupService {

    private final UserGroupRepository userGroupRepository;

    public UserGroupService(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    public UserGroup save(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }

    public void delete(UserGroup userGroup) {
        userGroupRepository.delete(userGroup);
    }

    public List<UserGroup> findAll() {
        return userGroupRepository.findAll();
    }

    public UserGroup getUserGroup(String userGroupName) {
        return userGroupRepository.findOneByUserGroupName(userGroupName);
    }

    public UserGroup getUserGroup(Long userGroupId) {
        return userGroupRepository.findOneByUserGroupId(userGroupId);
    }

    public List<UserGroup> findByUserGroupNameLikeIgnoreCase(String likeFilter) {
        return this.userGroupRepository.findByUserGroupNameLikeIgnoreCase(likeFilter);
    }
}