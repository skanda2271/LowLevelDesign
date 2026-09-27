package DesignPattrens.ProxyPattren;

public class UserDaoProxy implements UserDao{
    UserDaoImpl userImpl;
    Roles role;

    UserDaoProxy(Roles role){
        userImpl = new UserDaoImpl();
        this.role = role;
    }

    @Override
    public String getAllEmpls() throws Exception {
        if(role == Roles.ADMIN){
            return userImpl.getAllEmpls();
        }
        else{
            throw new Exception("Invalid Role");
        }
    }
}
