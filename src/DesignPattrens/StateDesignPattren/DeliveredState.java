package DesignPattrens.StateDesignPattren;

public class DeliveredState implements OrderState{
    @Override
    public void process(Order order) {
        System.out.println("Delivered Successfully");
    }
}
