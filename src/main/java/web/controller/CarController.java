package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCar(@RequestParam(value = "count",defaultValue = "5")int allCars, Model model) {
        List<Car> list = new ArrayList<>();
        list.add(new Car("Seat","Blue",2007));
        list.add(new Car("VW","Red",2008));
        list.add(new Car("Skoda","Grey",2009));
        list.add(new Car("Audi","Black",2010));
        list.add(new Car("Porsche","White",2011));
        list = CarService.carsCount(list,allCars);
        model.addAttribute("list",list);

        return "car";
    }
}
