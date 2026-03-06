package khj.DevTracker.layer.domain.problemAttempt.entity;

import jakarta.persistence.*;
import khj.DevTracker.layer.domain.problem.entity.Problem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

/**
 * 문제 시도 엔티티
 * @author khj
 * @since 2026-02-20
 */

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attemptId;

    @Column(nullable = false)
    private String approach;

    @Column
    private String result;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Problem problem;

    @Builder
    public ProblemAttempt(String approach,
                          String result) {
        this.approach = approach;
        this.result = result;
    }
}
