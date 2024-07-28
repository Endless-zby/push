package cn.byzhao.push.entity;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;


@Entity
@Data
@Table(name = "token")
@Proxy(lazy = false)
@AllArgsConstructor
@NoArgsConstructor
public class ClientDrive{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_id",unique=true, nullable = false, length = 64)
    private String clientId;

    @Column(name = "drive_id", nullable = false, length = 255)
    private String driveId;

}
