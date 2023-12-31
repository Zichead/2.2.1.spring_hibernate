package hiber.dao.impl;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<User> getUserWithCar (Car car){
      String hql = "FROM User WHERE car.model = :paramModel and car.series = :paramSeries";
      Query<User> query = sessionFactory.getCurrentSession().createQuery(hql,User.class)
              .setParameter("paramModel", car.getModel()).setParameter("paramSeries", car.getSeries());
      return query.getResultList();
   }


}
