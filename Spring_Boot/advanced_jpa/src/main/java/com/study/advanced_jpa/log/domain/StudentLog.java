package com.study.advanced_jpa.log.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "student_log")
public class StudentLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long logId;
    private String email;
    private String ip;
    @Column(name = "log_date")
    private Timestamp logDate;

    @Override
    public String toString() {
        return "StudentLog{" +
                "logId=" + logId +
                ", email='" + email + '\'' +
                ", ip='" + ip + '\'' +
                ", logDate=" + logDate +
                '}';
    }
}