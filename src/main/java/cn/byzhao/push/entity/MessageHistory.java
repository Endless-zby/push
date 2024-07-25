package cn.byzhao.push.entity;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "history")
@Proxy(lazy = false)
public class MessageHistory{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_id", nullable = false, length = 64)
    private String clientId;

    @Column(name = "drive_id", nullable = false, length = 255)
    private String driveId;

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "timestamp", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timestamp;
}

