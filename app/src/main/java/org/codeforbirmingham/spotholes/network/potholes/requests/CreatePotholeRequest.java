package org.codeforbirmingham.spotholes.network.potholes.requests;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import org.codeforbirmingham.spotholes.network.potholes.PotholeApiService;

import retrofit.mime.TypedFile;

/**
 * @author @justinharrison
 */
public class CreatePotholeRequest extends RetrofitSpiceRequest<Void, PotholeApiService> {

    private String name, apiKey;
    private double latitude, longitude;
    private TypedFile image;

    public CreatePotholeRequest(String apiKey, String name, double latitude, double longitude, TypedFile image) {
        super(Void.class, PotholeApiService.class);

        this.name = name;
        this.apiKey = apiKey;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
    }

    @Override
    public Void loadDataFromNetwork() throws Exception {
        return getService().createPothole(apiKey, name, latitude, longitude, image);
    }
}
