package DesignPattrens.StateDesignPattren;

public class PaidState implements OrderState{
    @Override
    public void process(Order order) {
        System.out.println("Paid Amount - paid state");
        order.setState(new ShippedState());
    }
}
