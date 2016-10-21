package com.weiss.forum.configuration;

import com.weiss.forum.logic.ContentController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Niklas
 */
@Configuration
public class ContentControllerConfiguration {

    @Bean
    public ContentController getContentController() {
	return new ContentController();
    }
}
