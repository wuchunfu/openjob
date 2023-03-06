package io.openjob.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

/**
 * @author stelin <swoft@qq.com>
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum TaskStatusEnum {

    /**
     * Unknown.
     */
    UNKNOWN(1, "unknown"),

    /**
     * Init.
     */
    INIT(5, "init"),

    /**
     * Failover task will be redispatched!
     */
    FAILOVER(10, "failover"),

    /**
     * running.
     */
    RUNNING(15, "running"),

    /**
     * Success.
     */
    SUCCESS(20, "success"),

    /**
     * Fail.
     */
    FAILED(25, "fail"),
    ;

    /**
     * Non finish status list.
     */
    public static final List<Integer> NON_FINISH_LIST = Arrays.asList(
            UNKNOWN.status,
            INIT.status,
            FAILOVER.status,
            RUNNING.status
    );

    /**
     * All status.
     */
    public static final List<Integer> ALL = Arrays.asList(
            UNKNOWN.status,
            INIT.status,
            FAILOVER.status,
            RUNNING.status,
            SUCCESS.status,
            FAILED.status
    );

    /**
     * Parse status.
     *
     * @param status status
     * @return TaskStatusEnum
     */
    public static TaskStatusEnum parse(Integer status) {
        return EnumSet.allOf(TaskStatusEnum.class).stream()
                .filter(s -> s.getStatus().equals(status))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("TaskStatusEnum parseValue(%s) failed!", status)));
    }

    /**
     * Status.
     */
    private final Integer status;

    /**
     * Message.
     */
    private final String message;
}
