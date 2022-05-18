package com.practice.designpattern.strategydesignpattern.strategy;

public class AttackStrategy implements Strategy {
    @Override
    public void actionCommand() {
        System.out.println("Attack Strategy :- Attack and kill");
    }
}
