package com.pritesh.us.api.respositoryImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pritesh.us.api.entity.Weather;
import com.pritesh.us.api.respository.WeatherRepository;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<String> findAllCities() {
		TypedQuery<String> query = em.createNamedQuery("Weather.findAll", String.class);
		return query.getResultList();
	}

	@Override
	public Weather WeatherByCity(String city) {
		return em.find(Weather.class, city);
	}

	@Override
	public String weatherByCityByProperty(String city, String property) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findByPropertyAndCity", Weather.class);
		query.setParameter("pCity", city);
		
		List<Weather> propertys = query.getResultList();

		if(!propertys.isEmpty())
		{
			if (property.equals("wind"))
			{
				String tempOutput = propertys.get(0).getWind(); 
				return  tempOutput;
			}
			else if (property.equals("humidity"))
			{
				String humidityOutput = propertys.get(0).getHumidity(); 
				return humidityOutput;
			}

			else if (property.equals("temperature"))
			{
				String humidityOutput = propertys.get(0).getTemperature(); 
				return humidityOutput;
			}
		}
		return " No Valid Data Found For City "; 
	}

	@Override
	public Weather weatherByCityByPropertyDateNTime(String city, String date) {
		
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findByDateAndCity", Weather.class);
		query.setParameter("pCity", city);
		query.setParameter("pDate", date);
		List<Weather> weathers = query.getResultList();
		
		if(!weathers.isEmpty())
		{
			return weathers.get(0);
		}else{
			return null;
		}
	}
	

	@Override
	public Weather createWeather(Weather weather) {
		em.persist(weather);
		return weather;
	}

}
