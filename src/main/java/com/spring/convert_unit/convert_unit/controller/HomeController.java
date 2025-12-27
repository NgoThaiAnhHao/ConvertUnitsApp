package com.spring.convert_unit.convert_unit.controller;

import com.spring.convert_unit.convert_unit.service.ConvertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private final ConvertService convertService;

    public HomeController(ConvertService convertService) {
        this.convertService = convertService;
    }

    @GetMapping("/")
    public String home(
            @RequestParam(required = false) Double value,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to,
            @RequestParam(required = false) String type,
            Model model
    ) {
        if (type == null) {
            type = "length";
        }


        model.addAttribute("type", type);
        model.addAttribute("units", convertService.getUnitsByType(type));
        model.addAttribute("value", value);
        model.addAttribute("from", from);
        model.addAttribute("to", to);

        return "dashboard";
    }

    @PostMapping("/convert")
    public String convert(  @RequestParam double value,
                            @RequestParam String from,
                            @RequestParam String to,
                            @RequestParam String type,
                            Model model) {

        double result = convertService.convert(value, from, to, type);

        model.addAttribute("value", value);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("result", result);
        model.addAttribute("type", type);
        model.addAttribute("units", convertService.getUnitsByType(type));

        return "dashboard";
    }




}
