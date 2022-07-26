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

        User user1 = (new User("user1", "Ivanov", "user1@gmail.com", new Car ("Mazda",5)));
        User user2 = (new User("user2", "user2", "Dulin@mail.com", new Car("Opel", 666)));
        User user3 = (new User("user3", "user3", "user3@mail.ru", new Car("Tesla", 3)));
        User user4 = (new User("user4", "Mamedov", "user4@mail.ru", new Car("Mercedes", 200)));
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);


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

        context.close();
    }
}
