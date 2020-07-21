package com.chihuo.zuul.ratelimit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.DefaultRateLimiterErrorHandler;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.RateLimiterErrorHandler;

@Component
public class RateLimiterHandler {

	Logger log = LoggerFactory.getLogger(RateLimiterHandler.class);

	@Bean
	public RateLimiterErrorHandler rateLimitErrorHandler() {
		return new DefaultRateLimiterErrorHandler() {
			@Override
			public void handleSaveError(String key, Exception e) {
				log.info("RateLimiterErrorHandler.handleSaveError---key={}---exception={}", key, e);
			}

			@Override
			public void handleFetchError(String key, Exception e) {
				log.info("RateLimiterErrorHandler.handleFetchError---key={}---exception={}", key, e);
			}

			@Override
			public void handleError(String msg, Exception e) {
				log.info("RateLimiterErrorHandler.handleError---msg={}---exception={}", msg, e);
			}
		};
	}

}
