package DesignPattrens.StateDesignPattren;

public interface OrderState {
    // State Design Pattren is a Behavioural Pattren where an object changes its behaviour
    // when its internal state changes

    //Insted of using long if-else or switch we create each state as an class -. we move each state to class

    void process(Order order);
}
