package com.pritesh.us.api.respository;

import java.util.List;

import com.pritesh.us.api.entity.Weather;

public interface WeatherRepository {
	public List<String> findAllCities();
	
	public Weather WeatherByCity(String city);
	
	public String weatherByCityByProperty(String city, String property);
	
	public Weather weatherByCityByPropertyDateNTime( String city,String date);
	
	public Weather createWeather(Weather weather);
}
