package com.example.demo.domain;

import lombok.Data;

@Data
public class FrozenQtyAddMsg extends BaseCalculateMsg {
    private String riskKey;

    private int side;

    private double frozenQty;
}
