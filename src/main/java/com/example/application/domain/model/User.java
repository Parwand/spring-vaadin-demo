package com.example.application.domain.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.*;

/**
 * Created by mweiss on 08.09.17.
 */
@Entity
@Table(name = "users")
public class User implements Serializable, Cloneable  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotEmpty
    @Column(unique=true)
    private String email;

    private String password;

    private String passwordResetToken;

    private String firstName;

    private String lastName;

    private String role;

    private Boolean enabled = Boolean.TRUE;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<VideoSet> videos = new ArrayList<>();

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(name = "rt_user_user_group",
                joinColumns         = {@JoinColumn(name = "user_id", nullable = false, updatable = false) },
                inverseJoinColumns  = {@JoinColumn(name = "user_group_id", nullable = false, updatable = false)}
                )
    private Set<UserGroup> userGroups = new HashSet<>();

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email
     *            new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password
     *            new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName
     *            new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName
     *            new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the value of enabled
     *
     * @return the value of enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Set the value of enabled
     *
     * @param enabled
     *            new value of enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void addVideo(VideoSet video) {
        videos.add(video);
        video.setUser(this);
    }

    public void removeVideo(VideoSet video) {
        videos.remove(video);
        video.setUser(null);
    }

    /**
     * Get the value of userGroups
     *
     * @return the value of userGroups
     */
    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    /**
     * Set the value of userGroups
     *
     * @param userGroups
     *            new value of userGroups
     */
    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public void addUserGroup(UserGroup userGroup){

        //avoid circular calls : assumes equals and hashcode implemented
        if(!userGroups.contains(userGroup)){
            userGroups.add(userGroup);

            //add method to Product : sets 'other side' of association
            userGroup.addUser(this);
        }
    }

    public void removeUserGroup(UserGroup userGroup){

        //avoid circular calls: assumes equals and hashcode implemented:
        if(userGroups.contains(userGroup)){
            userGroups.remove(userGroup);

            //add method to Product: set 'other side' of association:
            userGroup.removeUser(this);
        }
    }

    public boolean isPersisted() {
        return userId != null;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(passwordResetToken, user.passwordResetToken) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(role, user.role) &&
                Objects.equals(enabled, user.enabled) &&
                Objects.equals(userGroups, user.userGroups);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, email, password, passwordResetToken, firstName, lastName, role, enabled, userGroups);
    }

    @Override
    public String toString() {
        return email;
    }
}
