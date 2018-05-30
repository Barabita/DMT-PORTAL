package com.dmt.core.service;

import com.dmt.core.domain.Notification;

import java.util.List;

/**
 * @author mali.sahin
 * @since 20-May-18
 */

public interface NotificationService {

    public Notification save(Notification notification);

    public List<Notification> getNotificationListByReceiver(String receiver);
}
