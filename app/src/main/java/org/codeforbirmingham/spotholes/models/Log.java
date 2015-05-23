package org.codeforbirmingham.spotholes.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.realm.RealmObject;

/**
 * @author @justinharrison
 *
 * Pothole log. This Log holds the information about the status changes
 * of a Pothole, including the status, the date changed, and the name
 * of the administrator who changed it.
 */
public class Log extends RealmObject {

    @SerializedName("name")
    public String name;

    @SerializedName("status")
    public String status;

    @SerializedName("created_at")
    public Date createdAt;
}
