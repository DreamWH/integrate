package com.example.demo.config;

import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.script.DigestUtils;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
public class MyKeyGenerator {
    @Bean("myKey")
    public KeyGenerator myKey(){
        return new KeyGenerator(){
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                sb.append(Arrays.asList(params));
                return DigestUtils.sha1DigestAsHex(sb.toString());
            }
        };
    };
}
