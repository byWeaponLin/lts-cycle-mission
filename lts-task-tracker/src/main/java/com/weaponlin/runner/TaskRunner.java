package com.weaponlin.runner;

import com.github.ltsopensource.core.domain.Action;
import com.github.ltsopensource.core.domain.Job;
import com.github.ltsopensource.core.json.JSON;
import com.github.ltsopensource.core.logger.Logger;
import com.github.ltsopensource.core.logger.LoggerFactory;
import com.github.ltsopensource.spring.boot.annotation.JobRunner4TaskTracker;
import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.runner.JobContext;
import com.github.ltsopensource.tasktracker.runner.JobRunner;
import com.weaponlin.github.service.GithubService;
import com.weaponlin.job.GithubJob;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JobRunner4TaskTracker
public class TaskRunner implements JobRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskRunner.class);

    @Autowired
    private GithubService githubService;

    public Result run(JobContext jobContext) throws Throwable {
        try {
            Job job = jobContext.getJob();
            if (job != null) {
                System.out.println("======================run=====================");
                run(job);
                System.out.println("======================end=====================");
            } else {
                System.out.println("There is no job to execute!");
            }
        } catch (Exception e) {
            LOGGER.info("Run job failed!", e);
            return new Result(Action.EXECUTE_FAILED, e.getMessage());
        }
        return new Result(Action.EXECUTE_SUCCESS, "执行成功了，哈哈");
    }

    private void run(Job job) {
        GithubJob githubJob = JSON.parse(job.getParam("job"), GithubJob.class);
        if(githubJob == null || githubJob.getParam() == null){
            return;
        }
        List<Object> datas = githubService.getData(githubJob.getParam());
        System.out.println("================================");
        System.out.println("=============result=============" + datas.get(0));
        System.out.println("================================");
    }
}
