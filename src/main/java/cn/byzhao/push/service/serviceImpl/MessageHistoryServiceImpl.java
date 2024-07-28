package cn.byzhao.push.service.serviceImpl;

import cn.byzhao.push.entity.MessageHistory;
import cn.byzhao.push.repository.MessageHistoryRepository;
import cn.byzhao.push.service.MessageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class MessageHistoryServiceImpl implements MessageHistoryService {

    @Autowired
    private MessageHistoryRepository messageHistoryRepository;
    @Override
    public MessageHistory findById(Integer id) {
        return messageHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public Page<MessageHistory> findAllByClientId(String clientId, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        return messageHistoryRepository.findByClientId(clientId, pageable);
    }

    @Override
    public void save(MessageHistory messageHistory) {
        messageHistoryRepository.save(messageHistory);
    }


}
