package cn.byzhao.push.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "history")
@Proxy(lazy = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageHistory{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "client_id", nullable = false, length = 64)
    private String clientId;

    @Column(name = "drive_id", nullable = false, length = 255)
    private String driveId;

    @Column(name = "title")
    private String title;

    @Column(name = "body", nullable = false)
    private String body;

    @CreationTimestamp
    @Column(name = "timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timestamp;
}

