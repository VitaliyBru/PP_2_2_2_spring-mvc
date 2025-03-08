package web.services;

import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final List<Car> carsCatalog = new ArrayList<>();

    {
        carsCatalog.add(new Car("KIA K5", "Gravity Blue (B4U)", 1647900));
        carsCatalog.add(new Car("Geely Emgrand X7", "Brown", 745000));
        carsCatalog.add(new Car("Haval H5", "Белый Млечный путь", 729000));
        carsCatalog.add(new Car("Jetour X90 Plus", "Фиолетовый дракон", 2052000));
        carsCatalog.add(new Car("Faw Besturn X80", "Красный", 608000));
    }

    public List<Car> find(Integer count) {
        if (count == null || count > 5 || count <= 0) {
            count = 5;
        }
        return carsCatalog.stream().limit(count).toList();
    }
}
