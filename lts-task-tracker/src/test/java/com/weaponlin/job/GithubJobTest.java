package com.weaponlin.job;

import com.github.ltsopensource.core.json.JSON;
import org.junit.Test;

public class GithubJobTest {


    @Test
    public void testJSON() {
        GithubJob job = new GithubJob().setType("follower").setParam("followers").setUrl("https://api.github.com/users/byWeaponLin/followers");
        GithubJob githubJob = JSON.parse(JSON.toJSONString(job), GithubJob.class);
        System.out.println(githubJob);
    }
}