package khj.DevTracker.layer.domain.log.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
