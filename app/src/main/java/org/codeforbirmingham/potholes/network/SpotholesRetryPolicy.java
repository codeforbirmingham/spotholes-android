package org.codeforbirmingham.potholes.network;

import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.retry.RetryPolicy;

import retrofit.RetrofitError;

/**
 * @author @justinharrison
 */
public class SpotholesRetryPolicy implements RetryPolicy {

    private int retryCount = 3;

    @Override
    public int getRetryCount() {
        return retryCount;
    }

    @Override
    public void retry(SpiceException e) {
        if (e.getCause() instanceof RetrofitError) {
            RetrofitError error = (RetrofitError) e.getCause();
            if (error.getResponse() != null && error.getResponse().getStatus() == 401) {
                retryCount = 0;
            } else {
                retryCount--;
            }
        } else {
            retryCount --;
        }
    }

    @Override
    public long getDelayBeforeRetry() {
        return 0;
    }
}
