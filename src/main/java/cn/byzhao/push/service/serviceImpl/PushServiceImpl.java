package cn.byzhao.push.service.serviceImpl;

import cn.byzhao.push.service.PushService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class PushServiceImpl implements PushService {

    @Resource
    private AndroidService androidService;

    @Resource
    private APNsService apNsService;

    @Override
    public void send(String title, String message, String clientToken) {
        apNsService.send(title, message, clientToken);
        androidService.send(title, message, clientToken);
    }
}
