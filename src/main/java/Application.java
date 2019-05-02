import entities.Car;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class Application {
    public static Integer create(Car car){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(car);
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно создан " + car.toString());
        return car.getId();
    }

    public static List<Car> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //@SuppressWarnings("unchecked")
        List<Car> cars = session.createQuery("FROM Car").list();
        session.close();
        System.out.println(cars);
        return cars;
    }

    public static void update (Car car){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car c = (Car)session.load(Car.class,car.getId());
        c.setYear(car.getYear());
        c.setModel(car.getModel());
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно изменен "+ car.toString());

    }

    public static void delete(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car c = (Car) session.load(Car.class, id);
        session.delete(c);
        session.getTransaction().commit();
        session.close();
        System.out.println("успешно удалено " + c.toString());
    }

    public static void main(String[] args) {
        for(int i=1; i<=10; i++){
            create(new Car(i,2000+i,"modelN00"+i));
        }

        System.out.println(read());
        update(new Car(2,2019,"Mercedes"));
        delete(1);
    }
}
