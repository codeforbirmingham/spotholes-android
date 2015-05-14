package org.codeforbirmingham.potholes.network.potholes;

import org.codeforbirmingham.potholes.models.Pothole;

import retrofit.http.GET;

/**
 * @author @justinharrison
 */
public interface PotholeApiService {

    @GET("/potholes")
    Pothole.List getPotholes();
}