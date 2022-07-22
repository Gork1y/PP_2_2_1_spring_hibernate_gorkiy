package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        Ivan.setCar(Mazda);
        David.setCar(Gaz);
        Aleksey.setCar(Zil);
        Raul.setCar(Volga);
        userService.addUser(Ivan);
        userService.addUser(David);
        userService.addUser(Aleksey);
        userService.addUser(Raul);


        List<User> users = userService.getlistUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        for (User user : userService.getlistUsers()) {
            System.out.println(user + " " + user.getCar());
        }

        System.out.println("Автомобиль Мазда принадлежит: " + userService.getUserByCarModelAndSeries(Mazda));
        context.close();
    }
}
