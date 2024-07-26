package cn.byzhao.push.service.serviceImpl;

import cn.byzhao.push.entity.MessageHistory;
import cn.byzhao.push.repository.MessageHistoryRepository;
import cn.byzhao.push.service.MessageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageHistoryServiceImpl implements MessageHistoryService {

    @Autowired
    private MessageHistoryRepository messageHistoryRepository;
    @Override
    public MessageHistory findById(Integer id) {
        return messageHistoryRepository.findById(id).orElse(null);
    }
}
