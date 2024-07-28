package cn.byzhao.push.service.serviceImpl;

import cn.byzhao.push.entity.MessageHistory;
import cn.byzhao.push.service.MessageHistoryService;
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

    @Resource
    private MessageHistoryService messageHistoryService;

    @Override
    public void sendAndSave(MessageHistory messageHistory) {
        apNsService.send(messageHistory.getTitle(), messageHistory.getBody(), messageHistory.getDriveId());
        androidService.send(messageHistory.getTitle(), messageHistory.getBody(), messageHistory.getDriveId());
        messageHistoryService.save(messageHistory);
    }
}
