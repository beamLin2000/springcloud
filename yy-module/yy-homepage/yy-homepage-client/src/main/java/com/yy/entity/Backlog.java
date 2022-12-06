package com.yy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Backlog {
    private Integer waitNum;
    private Integer raiseNum;
    private Integer reviewedNum;
    private Integer repaidNum;
    private Integer applyNum;
}
