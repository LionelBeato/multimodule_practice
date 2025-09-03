package works.lionel.practice.notification;

import org.slf4j.LoggerFactory;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import works.lionel.practice.notification.internal.Notification;

import org.slf4j.Logger;

@Service
public class NotificationService {

    private static final Logger LOG = LoggerFactory.getLogger(NotificationService.class);

    @ApplicationModuleListener
    public void createNotification(NotificationDTO notif) {
        Notification notification = toEntity(notif);
        LOG.info("Received notification by module dependency for product {} in date {} by {}.",
                notification.getProductName(),
                notification.getDate(),
                notification.getFormat());
    }

    private Notification toEntity(NotificationDTO notification) {
        return new Notification("fsdf", notification.date(), notification.productName(), notification.format());
    }
}
