package works.lionel.practice.product;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import works.lionel.practice.notification.NotificationDTO;
import works.lionel.practice.notification.NotificationService;

@Service
public class ProductService {
    private final NotificationService notificationService;
    private final ApplicationEventPublisher events;

    public ProductService(ApplicationEventPublisher events, NotificationService notificationService) {
        this.events = events;
        this.notificationService = notificationService;
    }

    public void createProduct(ProductDTO product) {
        NotificationDTO notification = new NotificationDTO(LocalDateTime.now(), product.name(), "email");
        // notificationService.createNotification(notification);
        events.publishEvent(notification);
    }

    public List<ProductDTO> getAllProducts() {
        return List.of(
                new ProductDTO("Test Product", "A product for testing", 99.99),
                new ProductDTO("Another Product", "Another product for testing", 49.99));
    }
}
