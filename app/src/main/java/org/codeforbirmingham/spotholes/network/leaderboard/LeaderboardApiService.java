package org.codeforbirmingham.spotholes.network.leaderboard;

import org.codeforbirmingham.spotholes.models.User;

import retrofit.http.GET;

/**
 * @author @justinharrison
 */
public interface LeaderboardApiService {

    @GET("/leaderboard")
    User.List getLeaderboard();
}
