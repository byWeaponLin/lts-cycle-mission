package com.weaponlin.runner;

import com.github.ltsopensource.core.domain.Action;
import com.github.ltsopensource.core.domain.Job;
import com.github.ltsopensource.core.logger.Logger;
import com.github.ltsopensource.core.logger.LoggerFactory;
import com.github.ltsopensource.spring.boot.annotation.JobRunner4TaskTracker;
import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.runner.JobContext;
import com.github.ltsopensource.tasktracker.runner.JobRunner;

@JobRunner4TaskTracker
public class TaskRunner implements JobRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskRunner.class);

//    @Autowired
//    private GithubService githubService;

    public Result run(JobContext jobContext) throws Throwable {
        try {
            //TODO do what i want

        } catch (Exception e) {
            LOGGER.info("Run job failed!", e);
            return new Result(Action.EXECUTE_FAILED, e.getMessage());
        }
        return new Result(Action.EXECUTE_SUCCESS, "执行成功了，哈哈");
    }

    public void deal(Job job){
        
    }
}
