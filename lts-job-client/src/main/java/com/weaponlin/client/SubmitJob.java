package com.weaponlin.client;

import com.github.ltsopensource.core.domain.Job;
import com.github.ltsopensource.core.json.JSON;
import com.github.ltsopensource.jobclient.JobClient;
import com.github.ltsopensource.jobclient.domain.Response;
import com.google.common.collect.Lists;
import com.weaponlin.job.GithubJob;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubmitJob implements InitializingBean {

    /**
     * 自己的业务类,就可以这样引用了
     */
    @Autowired
    private JobClient jobClient;

    private String generateJobs() {
        List<GithubJob> jobs = Lists.newArrayList(
                new GithubJob().setType("follower").setParam("followers").setUrl("https://api.github.com/users/byWeaponLin/followers"),
                new GithubJob().setType("following").setParam("following").setUrl("https://api.github.com/users/byWeaponLin/following")
        );
        return JSON.toJSONString(jobs);
    }

    public void afterPropertiesSet() throws Exception {
        // 这里模拟提交任务

        Job job = new Job();
        job.setTaskId("t_555");
        job.setParam("jobs", generateJobs());
        job.setTaskTrackerNodeGroup("test_trade_TaskTracker");
        job.setNeedFeedback(true);
        job.setReplaceOnExist(true);        // 当任务队列中存在这个任务的时候，是否替换更新
//        job.setCronExpression("0 0/1 * * * ?");
//        job.setTriggerTime(DateUtils.addDay(new Date(), 1));
        Response response = jobClient.submitJob(job);
        System.out.println("客户端提交成功");
    }
}
