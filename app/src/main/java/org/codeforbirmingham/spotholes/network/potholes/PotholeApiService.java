package org.codeforbirmingham.spotholes.network.potholes;

import org.codeforbirmingham.spotholes.models.Pothole;

import retrofit.http.GET;

/**
 * @author @justinharrison
 */
public interface PotholeApiService {

    @GET("/potholes")
    Pothole.List getPotholes();
}
