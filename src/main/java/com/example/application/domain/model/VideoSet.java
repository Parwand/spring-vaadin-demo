package com.example.application.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by mweiss on 08.09.17.
 */
@Entity
@Table(name = "video_sets")
public class VideoSet implements Serializable, Cloneable  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long videoSetId;

    @NotEmpty
    private String filename;

    @NotEmpty
    private String mimeType;

    @NotEmpty
    private String title;

    @NotNull
    private Boolean isExternal = Boolean.FALSE;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private Boolean transcoded = Boolean.FALSE;

    @JsonProperty("deleted")
    private Boolean deleted = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_group_id")
    private UserGroup userGroup;

    public VideoSet() {
    }

    public VideoSet(String filename, String mimeType, String title, Date date, Boolean isExternal) {
        this.filename = filename;
        this.mimeType = mimeType;
        this.title = title;
        this.date = date;
        this.isExternal = isExternal;
    }

    public Long getVideoSetId() {
        return videoSetId;
    }

    /**
     * Get the value of filename
     *
     * @return the value of filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Set the value of filename
     *
     * @param filename
     *            new value of filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Get the value of mimeType
     *
     * @return the value of mimeType
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Set the value of mimeType
     *
     * @param mimeType
     *            new value of mimeType
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Boolean isIsExternal() {
        return isExternal;
    }

    public void setIsExternal(Boolean isExternal) {
        this.isExternal = isExternal;
    }

    /**
     * Get the value of title
     *
     * @return the value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of title
     *
     * @param title
     *            new value of title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the value of date
     *
     * @return the value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the value of date
     *
     * @param date
     *            new value of date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get the value of transcoded
     *
     * @return the value of transcoded
     */
    public Boolean isTranscoded() {
        return transcoded;
    }

    /**
     * Set the value of transcoded
     *
     * @param transcoded
     *            new value of transcoded
     */
    public void setTranscoded(Boolean transcoded) {
        this.transcoded = transcoded;
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

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user
     *            new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Set the value of userGroup
     *
     * @param userGroup
     *            new value of userGroup
     */
    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public Boolean getTranscoded() {
        return transcoded;
    }

    /**
     * Get the value of userGroup
     *
     * @return the value of userGroup
     */
    public UserGroup getUserGroup() {
        return userGroup;
    }

    public boolean isPersisted() {
        return videoSetId != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoSet videoSet = (VideoSet) o;
        return Objects.equals(videoSetId, videoSet.videoSetId) &&
                Objects.equals(filename, videoSet.filename) &&
                Objects.equals(mimeType, videoSet.mimeType) &&
                Objects.equals(title, videoSet.title) &&
                Objects.equals(isExternal,videoSet.isExternal)&&
                Objects.equals(date, videoSet.date) &&
                Objects.equals(transcoded, videoSet.transcoded) &&
                Objects.equals(deleted, videoSet.deleted) &&
                Objects.equals(user, videoSet.user) &&
                Objects.equals(userGroup, videoSet.userGroup);
    }

    @Override
    public int hashCode() {

        return Objects.hash(videoSetId, filename, mimeType, title, isExternal, date, transcoded, deleted, user, userGroup);
    }

    @Override
    public String toString() {
        return title;
    }
}
