package cn.byzhao.push.service.serviceImpl;

import cn.byzhao.push.entity.ClientDrive;
import cn.byzhao.push.repository.ClientDriveRepository;
import cn.byzhao.push.service.ClientDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientDriveServiceImpl implements ClientDriveService {

    @Autowired
    private ClientDriveRepository clientDriveRepository;


    @Override
    public ClientDrive getOne(Integer id) {
        return clientDriveRepository.findById(id).orElse(null);
    }
}
