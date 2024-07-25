package cn.byzhao.push.service;

import org.springframework.stereotype.Service;

@Service
public interface PushService {

    void send(String title, String message, String clientToken);
}
