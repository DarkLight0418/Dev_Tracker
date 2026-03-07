package khj.DevTracker.layer.domain.problem.enums;

public enum Status {
    OPEN("문제 정의"),
    SOLVED("문제 해결"),
    HOLD("일시 중단");

    private final String value;

    Status(String value) { this.value = value;}
}
