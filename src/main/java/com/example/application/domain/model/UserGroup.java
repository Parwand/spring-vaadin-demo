package com.example.application.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.*;

/**
 * Created by mweiss on 04.10.17.
 */
@Entity
@Table(name = "user_groups")
public class UserGroup {

    public static final String ADMIN = "admin";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userGroupId;

    @NotEmpty//Null(message = "Name is required")
    @Column(unique=true)
    private String userGroupName;

    @JsonProperty("deleted")
    private Boolean deleted = Boolean.FALSE;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "userGroup",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<VideoSet> videos = new ArrayList<>();

    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "userGroups"
    )
    private Set<User> users = new HashSet<>();

    public UserGroup() {
    }

    public UserGroup(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public Long getUserGroupId() {
        return userGroupId;
    }

    /**
     * Get the value of userGroupName
     *
     * @return the value of userGroupName
     */
    public String getUserGroupName() {
        return userGroupName;
    }

    /**
     * Set the value of userGroupName
     *
     * @param userGroupName
     *            new value of userGroupName
     */
    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    /**
     * Get the value of deleted
     *
     * @return the value of deleted
     */
    public Boolean isDeleted() {
        return deleted;
    }

    /**
     * Set the value of deleted
     *
     * @param deleted
     *            new value of deleted
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public void addVideo(VideoSet video) {
        videos.add(video);
        video.setUserGroup(this);
    }

    public void removeVideo(VideoSet video) {
        videos.remove(video);
        video.setUserGroup(null);
    }

    /**
     * Get the value of users
     *
     * @return the value of users
     */
    public Set<User> getUsers() {
        //force clients through our add and remove methods
        return users;
    }

    /**
     * Set the value of users
     *
     * @param users
     *            new value of users
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user){

        //assumes equals and hashcode implemented: avoid circular calls
        if(!users.contains(user)){
            users.add(user);

            //add method to Product : sets 'other side' of association
            user.addUserGroup(this);
        }
    }

    public void removeUser(User user){

        //assumes equals and hashcode implemented: avoid circular calls
        if(users.contains(user)){
            users.remove(user);

            //add method to Product : sets 'other side' of association
            user.removeUserGroup(this);
        }
    }

    public boolean isPersisted() {
        return userGroupId != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGroup userGroup = (UserGroup) o;
        return Objects.equals(userGroupId, userGroup.userGroupId) &&
                Objects.equals(userGroupName, userGroup.userGroupName) &&
                Objects.equals(deleted, userGroup.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userGroupId, userGroupName, deleted);
    }

    @Override
    public String toString() {
        return userGroupName;
    }
}
