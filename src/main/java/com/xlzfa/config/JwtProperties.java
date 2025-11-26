package com.xlzfa.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private String SecretKey;
    private Long Ttl;

}
