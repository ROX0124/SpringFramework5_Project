package mylab.notification.di.annot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public EmailNotificationService emailService() {
        return new EmailNotificationService("smtp.gmail.com", 587);
    }

    @Bean
    public SmsNotificationService smsService() {
        return new SmsNotificationService("SKT");
    }

    @Bean
    public NotificationManager notificationManager() {
        return new NotificationManager(emailService(), smsService());
    }
}