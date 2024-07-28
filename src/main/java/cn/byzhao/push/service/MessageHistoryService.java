package cn.byzhao.push.service;

import cn.byzhao.push.entity.MessageHistory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface MessageHistoryService {

    MessageHistory findById(Integer id);

    Page<MessageHistory> findAllByClientId(String clientId, int page, int size);

    void save(MessageHistory messageHistory);
}
