package com.practice.designpattern.strategydesignpattern;

import com.practice.designpattern.strategydesignpattern.strategy.AttackStrategy;
import com.practice.designpattern.strategydesignpattern.strategy.DefensiveStrategy;

public class CounterStrike {
    public static void main(String[] args) {
        Player terr = new Player("Terrorist");
        Player counter_terr = new Player("Counter Terrorist");

        System.out.println("Before bomb planting");
        terr.setStrategy(new AttackStrategy());
        counter_terr.setStrategy(new DefensiveStrategy());

        terr.action();
        counter_terr.action();

        System.out.println("after bomb planting");
        terr.setStrategy( new DefensiveStrategy());
        counter_terr.setStrategy(new AttackStrategy());

        terr.action();
        counter_terr.action();


    }



}
