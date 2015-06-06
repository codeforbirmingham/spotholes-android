package org.codeforbirmingham.spotholes.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author @justinharrison
 *
 * User model for Realm database
 */
public class User extends RealmObject {

    @PrimaryKey
    @SerializedName("id")
    private int id;

    @SerializedName("score")
    private int score;

    @SerializedName("imei")
    private String imei;

    @SerializedName("api_key")
    private String apiKey;

    public int getId() {
        return id;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getImei() {
        return imei;
    }

    public int getScore() {
        return score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
