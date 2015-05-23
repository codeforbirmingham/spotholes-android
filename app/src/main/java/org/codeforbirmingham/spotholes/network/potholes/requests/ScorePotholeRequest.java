package org.codeforbirmingham.spotholes.network.potholes.requests;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import org.codeforbirmingham.spotholes.network.potholes.PotholeApiService;

/**
 * @author @justinharrison
 */
public class ScorePotholeRequest extends RetrofitSpiceRequest<Void, PotholeApiService> {

    private String apiKey;
    private int potholeId, scoreDelta;

    public ScorePotholeRequest(String apiKey, int potholeId, int scoreDelta) {
        super(Void.class, PotholeApiService.class);

        this.apiKey = apiKey;
        this.potholeId = potholeId;
        this.scoreDelta = scoreDelta;
    }

    @Override
    public Void loadDataFromNetwork() throws Exception {
        return getService().scorePothole(apiKey, potholeId, scoreDelta);
    }
}
