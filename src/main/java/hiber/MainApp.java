package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      Car car1 = new Car("aa", 4522);
      Car car2 = new Car("bb",2652);
      Car car3 = new Car("cc",4654);
      Car car4 = new Car("dd",24522);

      carService.addCar(car1);
      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      carService.addCar(car2);
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      carService.addCar(car3);
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      carService.addCar(car4);
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));




      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      List<User> usersWithCar = userService.getUserWithCar(car4);
      for (User user : usersWithCar) {
         System.out.println("Owner " + car4);
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
