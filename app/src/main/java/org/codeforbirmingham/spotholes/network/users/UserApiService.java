package org.codeforbirmingham.spotholes.network.users;

import org.codeforbirmingham.spotholes.models.Pothole;
import org.codeforbirmingham.spotholes.models.User;

import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * @author @justinharrison
 */
public interface UserApiService {

    @GET("/users")
    User getUser(@Query("imei") String imei);

    @POST("/users")
    User createUser(@Query("name") String name, @Query("imei") String imei);

    @GET("/users/report")
    Pothole.List getUserReport(@Header("X-Api-Key") String apiKey);
}
