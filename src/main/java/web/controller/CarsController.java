package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

@Controller
public class CarsController {


    private final CarServiceImpl carService;
    @Autowired
    public CarsController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String  carsAction(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        model.addAttribute( "resultList", carService.getCarsFromList(carService.getCarList(), count));
        return "cars";
    }

}