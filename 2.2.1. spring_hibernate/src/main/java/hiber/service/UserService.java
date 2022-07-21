package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import javax.transaction.Transactional;
import java.util.List;
import java.sql.SQLException;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    @Transactional
    User getUserByCar(String model, int series);
    @Transactional
    User getUserByCars(Car car);
}
