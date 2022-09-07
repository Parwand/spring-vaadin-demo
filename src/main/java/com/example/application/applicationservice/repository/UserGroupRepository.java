package com.example.application.applicationservice.repository;

import com.example.application.domain.model.UserGroup;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mweiss on 04.10.17.
 */
@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

    UserGroup findOneByUserGroupName(String userGroupName);

    UserGroup findOneByUserGroupId(Long userGroupId);

    List<UserGroup> findByUserGroupNameLikeIgnoreCase(String nameFilter);

    // For lazy loading and filtering
    List<UserGroup> findByUserGroupNameLikeIgnoreCase(String nameFilter, Pageable pageable);
}