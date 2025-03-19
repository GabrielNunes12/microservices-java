package com.rocketseat.service.tasks.communication;

import com.rocketseat.service.tasks.NotificationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service.notification")
public interface NotificationClient {
    @PostMapping("/notification")
    void sendNotification(@RequestBody NotificationDTO notificationDTO);
}
