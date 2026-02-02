package khj.DevTracker.layer.domain.log.enums;

import lombok.Getter;

/**
 * 로그 타입 열거형
 * @author khj
 * @since 2026-02-01
 */

@Getter
public enum LogType {
    LOGIN("회원 로그인"),
    CREATE_RECORD("로그 생성"),
    CREATE_PROBLEM("문제 생성"),
    SOLVE_PROBLEM("문제 해결");

    private final String value;

    LogType(String value) { this.value = value;}
}
