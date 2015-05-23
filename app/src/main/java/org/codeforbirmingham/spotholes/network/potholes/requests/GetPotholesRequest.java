package org.codeforbirmingham.spotholes.network.potholes.requests;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import org.codeforbirmingham.spotholes.SpotholesApplication;
import org.codeforbirmingham.spotholes.network.potholes.PotholeApiService;

import io.realm.Realm;

/**
 * @author @justinharrison
 */
public class GetPotholesRequest extends RetrofitSpiceRequest<Void, PotholeApiService> {

    private String status;
    private double lowerLeftLatitude, lowerLeftLongitude, upperRightLatitude, upperRightLongitude;

    public GetPotholesRequest() {
        super(Void.class, PotholeApiService.class);
    }

    public GetPotholesRequest(String status,
                              double lowerLeftLatitude,
                              double lowerLeftLongitude,
                              double upperRightLatitude,
                              double upperRightLongitude) {
        super(Void.class, PotholeApiService.class);

        this.lowerLeftLatitude = lowerLeftLatitude;
        this.lowerLeftLongitude = lowerLeftLongitude;
        this.upperRightLatitude = upperRightLatitude;
        this.upperRightLongitude = upperRightLongitude;

    }

    @Override
    public Void loadDataFromNetwork() throws Exception {
        Realm realm = SpotholesApplication.getRealm();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(getService().getPotholes(status, lowerLeftLongitude, lowerLeftLatitude, upperRightLongitude, upperRightLatitude));
        realm.commitTransaction();
        return null;
    }
}
