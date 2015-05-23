package org.codeforbirmingham.spotholes.network.potholes.requests;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import org.codeforbirmingham.spotholes.models.Pothole;
import org.codeforbirmingham.spotholes.network.potholes.PotholeApiService;

/**
 * @author @justinharrison
 */
public class GetPotholeRequest extends RetrofitSpiceRequest<Pothole, PotholeApiService> {

    private int potholeId;

    public GetPotholeRequest(int potholeId) {
        super(Pothole.class, PotholeApiService.class);

        this.potholeId = potholeId;
    }

    @Override
    public Pothole loadDataFromNetwork() throws Exception {
        return getService().getPothole(potholeId);
    }
}
