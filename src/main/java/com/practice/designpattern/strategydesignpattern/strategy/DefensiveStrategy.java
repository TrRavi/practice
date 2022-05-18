package com.practice.designpattern.strategydesignpattern.strategy;

public class DefensiveStrategy implements Strategy {
    @Override
    public void actionCommand() {
        System.out.println("Defensive Strategy :- Protect the city");
    }
}
