package DesignPattrens.StateDesignPattren;

public class Order {

    OrderState state;

    public Order() {
        this.state = new CreateState();
    }

    public void process(){
        state.process(this);
    }

    public void setState(OrderState state){
        this.state = state;
    }
}
