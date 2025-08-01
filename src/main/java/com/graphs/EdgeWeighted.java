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
    public int other(int w){
        if(w==to) return from;
        if(w==from) return to;
        else throw new IllegalArgumentException();
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
    
    public int compareTo(EdgeWeighted other){
        return Double.compare(this.weight(),other.weight());
    }
}
