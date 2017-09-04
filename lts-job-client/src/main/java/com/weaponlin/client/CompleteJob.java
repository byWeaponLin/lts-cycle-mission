package com.weaponlin.client;


import com.github.ltsopensource.core.commons.utils.CollectionUtils;
import com.github.ltsopensource.core.domain.JobResult;
import com.github.ltsopensource.jobclient.support.JobCompletedHandler;
import com.github.ltsopensource.spring.boot.annotation.JobCompletedHandler4JobClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@JobCompletedHandler4JobClient
public class CompleteJob implements JobCompletedHandler {

    public void onComplete(List<JobResult> jobResults) {
        // 任务执行反馈结果处理
        if (CollectionUtils.isNotEmpty(jobResults)) {
            for (JobResult jobResult : jobResults) {
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 任务执行完成：" + jobResult);
            }
        }
    }
}
