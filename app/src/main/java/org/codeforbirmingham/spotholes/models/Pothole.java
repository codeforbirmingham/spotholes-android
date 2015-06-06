package org.codeforbirmingham.spotholes.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author @justinharrison
 *
 * This class is our basic Pothole model. This also servers as a RealmObject
 * that can be persisted to a local database.
 */
public class Pothole extends RealmObject {

    @PrimaryKey
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("score")
    private int score;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("thumb_url")
    private String thumbUrl;

    @SerializedName("pothole_logs")
    private RealmList<Log> logs;

    @SerializedName("user")
    private User user;

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public RealmList<Log> getLogs() {
        return logs;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public void setLogs(RealmList<Log> logs) {
        this.logs = logs;
    }
}
