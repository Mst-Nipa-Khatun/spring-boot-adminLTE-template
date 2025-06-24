package com.app.smartLoan.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseDto {
    protected Long id;
    protected Integer status;
}
