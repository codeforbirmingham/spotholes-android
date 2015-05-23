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
    public int id;

    @SerializedName("score")
    public int score;

    @SerializedName("imei")
    public String imei;

    @SerializedName("api_key")
    public String apiKey;

    public class List extends ArrayList<User> {

    }

}
