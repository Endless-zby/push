package cn.byzhao.push.repository;

import cn.byzhao.push.entity.ClientDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDriveRepository extends JpaRepository<ClientDrive, Integer> {
}
