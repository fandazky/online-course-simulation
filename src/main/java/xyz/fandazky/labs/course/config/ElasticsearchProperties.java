/**
 * Dana.id
 * Copyright (c) 2017‐2021 All Rights Reserved.
 */
package xyz.fandazky.labs.course.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("elasticsearch")
public class ElasticsearchProperties {

    private final String host = "";

    public String getHost() {
        return host;
    }
}