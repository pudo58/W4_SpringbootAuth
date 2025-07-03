package org.example.ex4.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class TokenService {
    String REDIS_KEY_PREFIX = "jwt-token:";

    @NonFinal
    @Value("${jwt.access.expire}")
    int expiration;

    RedisTemplate<String, Object> redisTemplate;
    ListOperations<String, String> listOps;

    public void saveTokenToRedis (String username, String token) {
        String key = REDIS_KEY_PREFIX + username;
        listOps.leftPush(key, token);
        redisTemplate.expire(key, expiration, TimeUnit.SECONDS);
    }

    public List<String> getTokenFromRedis (String username) {
        String key = REDIS_KEY_PREFIX + username;
        return listOps.range(key,0, -1);
    }

    public  void deleteTokenFromRedis (String username) {
        String key = REDIS_KEY_PREFIX + username;
        redisTemplate.delete(key);
    }

}
