package org.codeforbirmingham.spotholes.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.realm.RealmObject;

/**
 * @author @justinharrison
 *         Pothole log. This Log holds the information about the status changes
 *         of a Pothole, including the status, the date changed, and the name
 *         of the administrator who changed it.
 */
public class Log extends RealmObject {

    @SerializedName("name")
    private String name;

    @SerializedName("status")
    private String status;

    @SerializedName("created_at")
    private Date createdAt;

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
