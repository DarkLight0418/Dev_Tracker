package khj.DevTracker.layer.domain.log.entity;


import jakarta.persistence.*;
import khj.DevTracker.layer.domain.log.enums.LogType;
import khj.DevTracker.layer.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

/**
 * 로그 엔티티 클래스
 * @author khj
 * @since 2026-02-01
 */

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @Column(nullable = false)
    private Long targetId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LogType type;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Builder
    private Log(Long targetId, LogType type, Member member) {
        this.targetId = targetId;
        this.type = type;
        this.member = member;
    }
}
