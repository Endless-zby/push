package cn.byzhao.push.repository;

import cn.byzhao.push.entity.MessageHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageHistoryRepository extends JpaRepository<MessageHistory, Integer> {

    Page<MessageHistory> findByClientId(String clientId, Pageable pageable);

}
