package com.github.hdghg.edgecenterrucdnmock.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class PrintBuildInfoListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(PrintBuildInfoListener.class);

    @Autowired
    private BuildProperties buildProperties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Version: " + buildProperties.getVersion() + ", build at: " + buildProperties.getTime());
    }
}
