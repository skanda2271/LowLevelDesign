package DesignPattrens.StateDesignPattren.SingleTonPattren;

public class SingletonPattren {

    private static SingletonPattren INSTANCE;

    private SingletonPattren(){

    }

    public static SingletonPattren getInstance(){
        if(INSTANCE == null){
            synchronized (SingletonPattren.class){
                if(INSTANCE == null){
                    INSTANCE = new SingletonPattren();
                }
            }
        }
        return INSTANCE;
    }
}
