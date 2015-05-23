package org.codeforbirmingham.spotholes.network.potholes;

import org.codeforbirmingham.spotholes.models.Pothole;

import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Multipart;
import retrofit.http.PATCH;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedFile;

/**
 * @author @justinharrison
 */
public interface PotholeApiService {

    @GET("/potholes")
    Pothole.List getPotholes();

    @GET("/potholes")
    Pothole.List getPotholes(
            @Query("status") String status,
            @Query("lower_left_longitude") double lowerLeftLongitude,
            @Query("lower_left_latitude") double lowerLeftLatitude,
            @Query("upper_right_longitude") double upperRightLongitude,
            @Query("upper_right_latitude") double upperRightLatitude
    );

    @Multipart
    @POST("/potholes")
    Void createPothole(
            @Header("X-Api-Key") String apiKey,
            @Query("name") String name,
            @Query("latitude") double latitude,
            @Query("longitude") double longitude,
            @Part("image") TypedFile photo
    );

    @GET("/potholes/{id}")
    Pothole getPothole(@Path("id") int id);

    @PATCH("/potholes/{id}/score")
    Void scorePothole(
            @Header("X-Api-Key") String apiKey,
            @Path("id") int id,
            @Query("score_delta") int scoreDelta
    );
}
