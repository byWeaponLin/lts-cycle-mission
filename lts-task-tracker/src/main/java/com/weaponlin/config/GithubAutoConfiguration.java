package com.weaponlin.config;

import com.oneapm.touch.retrofit.autoconfigure.RetrofitAutoConfiguration;
import com.oneapm.touch.retrofit.boot.RetrofitServiceScan;
import com.weaponlin.github.endpoint.GithubEndpoint;
import com.weaponlin.github.service.GithubService;
import com.weaponlin.github.service.RetrofitCallAdaptor;
import com.weaponlin.github.service.impl.GithubServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Slf4j
@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@ConditionalOnClass(RetrofitCallAdaptor.class)
@RetrofitServiceScan("com.weaponlin.github.endpoint")
@AutoConfigureAfter(RetrofitAutoConfiguration.class)
public class GithubAutoConfiguration {

    @Autowired
    public GithubAutoConfiguration(){

    }

    @Bean
    @ConditionalOnMissingBean
    public GithubService githubService(GithubEndpoint githubEndpoint) {
        return new GithubServiceImpl(githubEndpoint);
    }

}
