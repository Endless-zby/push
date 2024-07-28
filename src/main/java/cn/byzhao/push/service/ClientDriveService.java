package cn.byzhao.push.service;

import cn.byzhao.push.entity.ClientDrive;
import org.springframework.stereotype.Service;

@Service
public interface ClientDriveService {

    ClientDrive findById(Integer id);

    ClientDrive save(ClientDrive clientDrive);

    ClientDrive findByClientId(String clientId);

}
