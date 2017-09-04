package com.weaponlin.job;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class GithubJob implements Serializable{
    private String type;
    private String url;
    private String param;
    private String result;
}
