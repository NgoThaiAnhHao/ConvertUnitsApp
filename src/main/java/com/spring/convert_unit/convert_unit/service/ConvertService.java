package com.spring.convert_unit.convert_unit.service;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface ConvertService {

    Map<String, Double> LENGTH_MAP = new LinkedHashMap<>();
    Map<String, Double> WEIGHT_MAP = new LinkedHashMap<>();

    double convert(double value, String from, String to, String type);
    double convertByMap(
            double value,
            String from,
            String to,
            Map<String, Double> map
    );

    double temperatureConvert(double value, String from, String to);

    List<String> getUnitsByType(String type);


}
