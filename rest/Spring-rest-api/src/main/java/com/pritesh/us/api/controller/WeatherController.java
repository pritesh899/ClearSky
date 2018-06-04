package com.pritesh.us.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pritesh.us.api.entity.Weather;
import com.pritesh.us.api.service.WeatherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags="Weather")
public class WeatherController {
	@Autowired
	private WeatherService weatherService;
	
	
	//Finding all cities
	@RequestMapping(method = RequestMethod.GET, value = "/weather/cities")
	@ApiOperation(value = "Find all cities", notes = "Return all cities from database")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal server error")
	})
	public List<String> findAllCities()
	{
		return weatherService.findAllCities();
	}
	
	//By City
	@RequestMapping(method = RequestMethod.GET, value = "/weather/{city}")
	@ApiOperation(value = "Find weather by city", notes = "Return weather report for city from database")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal server error")
	})
	public Weather WeatherByCity(@PathVariable("city") String city)
	{
		return weatherService.WeatherByCity(city);
	}
	
	//By City and Property
	@RequestMapping(method = RequestMethod.GET, value = "/weather/city/{city}/{property}")
	@ApiOperation(value = "Find weather by city and property", notes = "Return weather property from database")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal server error")
	})
	public String weatherByCityByProperty(@PathVariable("city") String city, @PathVariable("property") String property)
	{
		return weatherService.weatherByCityByProperty(city, property);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/weather/{city}/{date}")
	@ApiOperation(value = "Find weather by date", notes = "Return weather report from database")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal server error")
	})
	public Weather weatherByCityByPropertyDateNTime(@PathVariable("city") String city,@PathVariable("date") String date)
	{
		return weatherService.weatherByCityByPropertyDateNTime(city,date);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/weather")
	@ApiOperation(value = "create new weather report", notes = "create weather report in database")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 400, message = "bad request"),
			@ApiResponse(code = 500, message = "internal server error")
	})
	public Weather createWeather( @RequestBody Weather weather)
	{
		return weatherService.createWeather(weather);
	}

	
	
	
}
