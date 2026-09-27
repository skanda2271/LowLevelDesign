package DesignPattrens.StateDesignPattren;

public class ShippedState implements OrderState{
    @Override
    public void process(Order order) {
        System.out.println("Shipped Item - shipped state");
        order.setState(new DeliveredState());
    }
}
