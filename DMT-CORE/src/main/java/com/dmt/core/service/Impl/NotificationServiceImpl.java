package com.dmt.core.service.Impl;

import com.dmt.core.domain.Notification;
import com.dmt.core.repository.NotificationRepository;
import com.dmt.core.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author mali.sahin
 * @since 20-May-18
 */
@Service
public class NotificationServiceImpl implements NotificationService {


    @Autowired
    @Qualifier("notificationRepository")
    private NotificationRepository notificationRepository;

    @Override
    @Transactional
    public Notification save(Notification notification) {
        notification.setCreDate(new Date());
        notification.setId(String.valueOf(new Date().getTime()));
        notification.setCreUser("SYSTEM");
        return notificationRepository.save(notification);
    }
}
