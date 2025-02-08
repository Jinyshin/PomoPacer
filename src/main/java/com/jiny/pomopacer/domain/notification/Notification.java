package com.jiny.pomopacer.domain.notification;

import com.jiny.pomopacer.domain.ai.AiMessage;
import com.jiny.pomopacer.domain.timer.TimerSession;
import com.jiny.pomopacer.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timer_session_id", nullable = false)
    private TimerSession timerSession;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ai_message_id", nullable = false)
    private AiMessage aiMessage;

    private LocalDateTime sentAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
