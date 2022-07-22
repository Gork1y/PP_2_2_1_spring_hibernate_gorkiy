package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import javax.transaction.Transactional;
import java.util.List;
import java.sql.SQLException;

public interface UserService {
    void addUser(User user);

    List<User> getlistUsers();

    User getUserByCarModelAndSeries(Car car);
}
