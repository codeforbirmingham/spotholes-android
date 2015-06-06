package org.codeforbirmingham.spotholes.network.leaderboard;

import org.codeforbirmingham.spotholes.models.User;
import org.codeforbirmingham.spotholes.models.UserList;

import retrofit.http.GET;

/**
 * @author @justinharrison
 */
public interface LeaderboardApiService {

    @GET("/leaderboard")
    UserList getLeaderboard();
}
