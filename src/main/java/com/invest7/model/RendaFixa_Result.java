package com.invest7.model;

import java.math.BigDecimal;

public class RendaFixa_Result {
    private String name;
    private BigDecimal pessimistic;
    private BigDecimal average;
    private BigDecimal optimistic;
    private String percentPessimistic;
    private String percentAverage;
    private String percentOptimistic;

    public RendaFixa_Result(String name, BigDecimal pessimistic, BigDecimal average, BigDecimal optimistic,
                             String percentPessimistic, String percentAverage, String percentOptimistic) {
        this.name = name;
        this.pessimistic = pessimistic;
        this.average = average;
        this.optimistic = optimistic;
        this.percentPessimistic = percentPessimistic;
        this.percentAverage = percentAverage;
        this.percentOptimistic = percentOptimistic;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPessimistic() {
        return pessimistic;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public BigDecimal getOptimistic() {
        return optimistic;
    }

    public String getPercentPessimistic() {
        return percentPessimistic;
    }

    public String getPercentAverage() {
        return percentAverage;
    }

    public String getPercentOptimistic() {
        return percentOptimistic;
    }
}