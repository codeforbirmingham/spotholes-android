package org.codeforbirmingham.spotholes.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;
import com.squareup.okhttp.OkHttpClient;

import org.codeforbirmingham.spotholes.R;
import org.codeforbirmingham.spotholes.SpotholesApplication;
import org.codeforbirmingham.spotholes.network.potholes.PotholeApiService;
import org.codeforbirmingham.spotholes.utils.Util;
import org.codeforbirmingham.spotholes.util.Environment;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

/**
 * @author @justinharrison
 */
public class SpotholesSpiceService extends RetrofitGsonSpiceService {

    @Override
    protected Converter createConverter() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();
        return  new GsonConverter(gson);
    }

    @Override
    protected String getServerUrl() {
        return Environment.SPOTHOLES_ENDPOINT;
    }

    protected RestAdapter.Builder createRestAdapterBuilder() {

        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("X-Screen-Density", Util.getScreenDensityString(SpotholesApplication.getContext()));
                request.addHeader("Accept", "application/vnd.spotholes.v1+json");
            }
        };

        return new RestAdapter.Builder()
                .setEndpoint(getServerUrl())
                .setRequestInterceptor(requestInterceptor)
                .setConverter(getConverter())
                .setClient(new OkClient(getClient()));
    }

    @Override
    public void onCreate() {
        super.onCreate();

        addRetrofitInterface(PotholeApiService.class);
    }

    protected OkHttpClient getClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        KeyStore keyStore = readKeyStore();
        SSLContext sslContext = null;
        KeyManagerFactory keyManagerFactory = null;
        TrustManagerFactory trustManagerFactory = null;
        try {
            sslContext = SSLContext.getInstance("SSL");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try {
            keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, SpotholesApplication.getContext().getString(R.string.store_pass).toCharArray());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try {
            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        okHttpClient.setSslSocketFactory(sslContext.getSocketFactory());
        return okHttpClient;
    }
}
