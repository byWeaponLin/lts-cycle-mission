package com.weaponlin.github.service.impl;

import com.weaponlin.github.endpoint.GithubEndpoint;
import com.weaponlin.github.service.GithubService;
import com.weaponlin.github.service.RetrofitCallAdaptor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GithubServiceImpl implements GithubService, RetrofitCallAdaptor{

    private final GithubEndpoint githubEndpoint;

    @Autowired
    public GithubServiceImpl(GithubEndpoint githubEndpoint) {
        this.githubEndpoint = githubEndpoint;
    }

    @Override
    public List<Object> getData(String p) {
        return execute(githubEndpoint.getGithubData(p));
    }
}
