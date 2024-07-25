package cn.byzhao.push.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AndroidService {

    public void send(String title, String message, String clientToken) {
        log.info("android.....");
    }
}
