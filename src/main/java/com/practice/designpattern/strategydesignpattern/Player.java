package com.practice.designpattern.strategydesignpattern;

import com.practice.designpattern.strategydesignpattern.strategy.Strategy;

public class Player {

    Strategy behaviour;
    String type;
    public Player(String type){
        this.type = type;

    }

    public void setStrategy(Strategy behaviour){
        this.behaviour = behaviour;
    }

    public void action(){
        System.out.println("type = "+this.type);
        behaviour.actionCommand();
    }
}
