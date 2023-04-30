package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private List<Car> carList = Arrays.asList(new Car(2, "Focus", 90),
                                        new Car(2, "Focus", 90),
                                        new Car(3, "Fiesta", 95),
                                        new Car(4, "Superb", 110),
                                        new Car(5, "Yeti", 95));

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getCarsFromList(List<Car> list, Integer count) {
        if(count == null || count > 5) {
            return list;
        }
        return list.subList(0, count);
    }
}
