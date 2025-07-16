package com.graphs;

public class EdgeWeighted {
    private int from;
    private int to;
    private double weight;
    public EdgeWeighted(int from, int to, double weight){
        this.from=from;
        this.to=to;
        this.weight=weight;
    }
    public int from(){
        return this.from;
    }
    public int to(){
        return this.to;
    }
    public double weight(){
        return this.weight;
    }
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("{ ");
        res.append("from"+ from +", ");
        res.append("to"+ to +", ");
        res.append("weight"+ weight);
        res.append(" }");
        return res.toString();
    }
}
