package org.codeforbirmingham.spotholes.network.leaderboard;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import org.codeforbirmingham.spotholes.models.User;

/**
 * @author @justinharrison
 */
public class GetLeaderboardRequest extends RetrofitSpiceRequest<User.List, LeaderboardApiService> {

    public GetLeaderboardRequest() {
        super(User.List.class, LeaderboardApiService.class);
    }

    @Override
    public User.List loadDataFromNetwork() throws Exception {
        return getService().getLeaderboard();
    }
}
