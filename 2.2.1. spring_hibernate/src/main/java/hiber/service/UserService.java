package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import javax.transaction.Transactional;
import java.util.List;
import java.sql.SQLException;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUserByCar(Car car);
    void addCar(Car car);
}
