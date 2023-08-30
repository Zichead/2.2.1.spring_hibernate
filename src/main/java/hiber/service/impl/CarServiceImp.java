package hiber.service.impl;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.service.CarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    final
    CarDao carDao;

    public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    @Transactional (readOnly = true)
    @Override
    public List<Car> listCar() {
        return carDao.listCar();
    }
}
