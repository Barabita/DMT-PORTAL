package com.dmt.core.repository;

import com.dmt.core.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mali.sahin
 * @since 20-May-18
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, String>, JpaSpecificationExecutor {

    public List<Notification> findByReceiver(String receiver);
}
