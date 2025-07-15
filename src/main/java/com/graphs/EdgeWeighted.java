package com.graphs;

public class EdgeWeighted {
    private int from;
    private int to;
    private float weight;
    public EdgeWeighted(int from, int to, float weight){
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
    public float weight(){
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
