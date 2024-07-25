package cn.byzhao.push.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Table(name = "token")
@Proxy(lazy = false)
public class ClientDrive{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_id", nullable = false, length = 64)
    private String clientId;

    @Column(name = "drive_id", nullable = false, length = 255)
    private String driveId;

}
