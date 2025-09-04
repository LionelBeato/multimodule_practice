package works.lionel.practice.notification.controller;

import org.springframework.web.bind.annotation.*;
import works.lionel.practice.notification.NotificationService;
import works.lionel.practice.notification.NotificationDTO;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public void createNotification(@RequestBody NotificationDTO notification) {
        notificationService.createNotification(notification);
    }
}
