package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User Ivan = (new User("Ivan", "Ivanov", "Ivan@gmail.com"));
        User David = (new User("David", "Dulin", "Dulin@mail.com"));
        User Aleksey = (new User("Aleksey", "Popovich", "Aleksey@mail.ru"));
        User Raul = (new User("Raul", "Mamedov", "Raul@mail.ru"));

        Car Mazda = new Car("Mazda", 9);
        Car Gaz = new Car("Gaz", 53);
        Car Zil = new Car("Zil", 301);
        Car Mercedes = new Car("Mercedes", 200);
        Car Volga = new Car("Volga", 3310);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        userService.add(Ivan.setCar(Gaz).setUser(Ivan));
        userService.add(David.setCar(Volga).setUser(David));
        userService.add(Aleksey.setCar(Mercedes).setUser(Aleksey));
        userService.add(Raul.setCar(Zil).setUser(Raul));

        for (User user : userService.listUsers()) {
            System.out.println(user + " " + user.getCar());
        }

        try {
            System.out.println(userService.getUserByCar(Mazda));
        } catch (NoResultException e) {
            System.out.println("Пользователь с авто " + Mazda + " не найден");
        }

        try {
            System.out.println(userService.getUserByCar(Gaz));
        } catch (NoResultException e) {
            System.out.println("Пользователь с авто " + Gaz + " не найден");
        }

        try {
            System.out.println(userService.getUserByCar("Zil", 301));
        } catch (NoResultException e) {
            System.out.println("Пользователь с авто " + Zil + " не найден");
        }

        try {
            System.out.println(userService.getUserByCar("Mercedes", 200));
        } catch (NoResultException e) {
            System.out.println("Пользователь с авто " + Mercedes + " не найден");
        }

        try {
            System.out.println(userService.getUserByCar("Volga", 3310));
        } catch (NoResultException e) {
            System.out.println("Пользователь с авто " + Volga + " не найден");
        }

        context.close();
    }
}
