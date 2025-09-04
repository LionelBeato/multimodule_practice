package works.lionel.practice.notification;

import java.time.LocalDateTime;

public record NotificationDTO(LocalDateTime date, String productName, String format) {

}
