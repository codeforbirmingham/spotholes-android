package org.codeforbirmingham.spotholes.network.leaderboard;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import org.codeforbirmingham.spotholes.models.User;
import org.codeforbirmingham.spotholes.models.UserList;

/**
 * @author @justinharrison
 */
public class GetLeaderboardRequest extends RetrofitSpiceRequest<UserList, LeaderboardApiService> {

    public GetLeaderboardRequest() {
        super(UserList.class, LeaderboardApiService.class);
    }

    @Override
    public UserList loadDataFromNetwork() throws Exception {
        return getService().getLeaderboard();
    }
}
