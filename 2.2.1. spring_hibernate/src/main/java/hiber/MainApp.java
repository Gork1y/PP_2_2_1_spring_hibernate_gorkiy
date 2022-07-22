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

        User Ivan = (new User("Ivan", "Ivanov", "Ivan@gmail.com", new Car ("Mazda",8)));
        User David = (new User("David", "Dulin", "Dulin@mail.com", new Car("Gaz", 53)));
        User Aleksey = (new User("Aleksey", "Popovich", "Aleksey@mail.ru", new Car("Zil", 301)));
        User Raul = (new User("Raul", "Mamedov", "Raul@mail.ru", new Car("Mercedes", 200)));
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

        context.close();
    }
}
