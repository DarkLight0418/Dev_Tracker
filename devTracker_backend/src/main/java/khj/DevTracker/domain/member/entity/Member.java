package khj.DevTracker.domain.member.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 회원 엔티티 클래스
 * @author kcw
 * @since 2026-01-21
 */

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String password;

    private String nickname;
}
