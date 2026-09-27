package DesignPattrens.StateDesignPattren;

public class CreateState implements OrderState{
    @Override
    public void process(Order order) {
        System.out.println("Making Payment - created state");
        order.setState(new PaidState());
    }
}
