package cn.byzhao.push.service;

import cn.byzhao.push.entity.MessageHistory;
import org.springframework.stereotype.Service;

@Service
public interface PushService {

    void sendAndSave(MessageHistory messageHistory);
}
