package works.lionel.practice.notification.internal;

import java.time.LocalDateTime;

public class Notification {
    private String message;
    private String productName;
    private LocalDateTime date;
    private String format;

    public Notification(String message, LocalDateTime date, String productName, String format) {
        this.message = message;
        this.productName = productName;
        this.date = date;
        this.format = format;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

}
