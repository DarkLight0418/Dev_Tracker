package khj.DevTracker.layer.domain.problemAttempt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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

}
