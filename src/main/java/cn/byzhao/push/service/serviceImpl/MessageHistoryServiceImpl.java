package cn.byzhao.push.service.serviceImpl;

import cn.byzhao.push.entity.MessageHistory;
import cn.byzhao.push.repository.MessageHistoryRepository;
import cn.byzhao.push.service.MessageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MessageHistoryServiceImpl implements MessageHistoryService {

    @Autowired
    private MessageHistoryRepository messageHistoryRepository;
    @Override
    public MessageHistory getOne(Integer id) {
        return messageHistoryRepository.findById(id).orElse(null);
    }
}
