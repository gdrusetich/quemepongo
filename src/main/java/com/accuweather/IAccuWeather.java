package com.accuweather;

import java.util.Map;

public interface IAccuWeather {
	Map<String, Object> getWeather(String ciudad);
}
