package DesignPattrens.StateDesignPattren;

public class StateMain {
    public static void main(String[] args){
        Order order = new Order();
        order.process();
        order.process();
        order.process();
        order.process();
    }

}
