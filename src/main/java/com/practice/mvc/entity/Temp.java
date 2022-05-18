package com.practice.mvc.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "temptable")
@Data
public class Temp {

    @Id
    private int id;

    @Column(name = "bucket_name",nullable = false)
    private String bucketName;

    @Column(name = "amount",nullable = false)
    private Double amount;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "created_by",nullable = false)
    private String createdBy;

    @Column(name = "updated_by",nullable = false)
    private String updatedBy;
}
