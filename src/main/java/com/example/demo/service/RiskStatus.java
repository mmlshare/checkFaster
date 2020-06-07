package com.example.demo.service;

import lombok.Data;

@Data
public class RiskStatus {
    private double maxQty;
    private double frozenQty1;
    private double frozenQty2;
    private double usedQty;
    private double maxBidQty;
    private double maxSellQty;
}
