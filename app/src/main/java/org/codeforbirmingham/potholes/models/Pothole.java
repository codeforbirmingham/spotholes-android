package org.codeforbirmingham.potholes.models;

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
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("score")
    public int score;

    @SerializedName("image_url")
    public String imageUrl;

    @SerializedName("thumb_url")
    public String thumbUrl;

    @SerializedName("pothole_logs")
    public RealmList<Log> logs;

    @SerializedName("user")
    public User user;

    public static class List extends ArrayList<Pothole> {
    }

}
