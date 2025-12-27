package com.spring.convert_unit.convert_unit.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ConvertServiceImpl implements ConvertService {
    static {
        WEIGHT_MAP.put("milligram", 0.001);
        WEIGHT_MAP.put("gram", 1.0);
        WEIGHT_MAP.put("kilogram", 1000.0);
        WEIGHT_MAP.put("ounce", 28.3495);
        WEIGHT_MAP.put("pound", 453.592);
    };

    static {
        LENGTH_MAP.put("millimeter",0.001);
        LENGTH_MAP.put("centimeter",0.01);
        LENGTH_MAP.put("meter",1.0);
        LENGTH_MAP.put("kilometer",1000.0);
        LENGTH_MAP.put("inch" ,0.0254);
        LENGTH_MAP.put("foot",0.3048);
        LENGTH_MAP.put("yard",0.9144);
        LENGTH_MAP.put("mile",1609.34);
    };


    @Override
    public double convert(double value, String from, String to, String type) {
        return switch (type) {
            case "temperature" -> temperatureConvert(value, from, to);
            case "weight" -> convertByMap(value, from, to, WEIGHT_MAP);
            default -> convertByMap(value, from, to, LENGTH_MAP);
        };
    }

    @Override
    public double convertByMap(double value, String from, String to, Map<String, Double> map) {
        double baseValue = value * map.get(from);
        return Double.parseDouble(
                String.format("%.5f", baseValue / map.get(to))
        );
    }

    @Override
    public double temperatureConvert(double value, String from, String to) {
        if (from.equals(to)) return value;

        double celsius = switch (from) {
            case "fahrenheit" -> (value - 32) * 5 / 9;
            case "kelvin" -> value - 273.15;
            default -> value;
        };


        double result = switch (to) {
            case "fahrenheit" -> celsius * 9 / 5 + 32;
            case "kelvin" -> celsius + 273.15;
            default -> celsius;
        };

        return Double.parseDouble(
                String.format("%.5f", result)
        );
    }

    @Override
    public List<String> getUnitsByType(String type) {
        return switch(type) {
            case "temperature" -> List.of("celsius", "fahrenheit", "kelvin");
            case "weight" ->  List.copyOf(ConvertService.WEIGHT_MAP.keySet());
            default -> List.copyOf(ConvertService.LENGTH_MAP.keySet());
        };
    }
}
