package com.stoom.challenge.util;

import com.stoom.challenge.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class GeocodingService {
	
	private RestTemplate restTemplate;
	
	@Autowired
	private MapperObjetUtil mapperObjetUtil;
	
	private static final String API_GOOGLE = "https://maps.googleapis.com/maps"
			+ "/api/geocode/json?address={streetName},{number},{city},{zipcode}\n" + 
			"&key={key}";
	
	@Value("${api.key}")
	private String apiKey;

	 
	public ApiGeocodingResponses apiConsumer(Endereco endereco) {
		
		Map<String, Object> params = new HashMap<String, Object>();
	    params.put("streetName", endereco.getStreetName());
	    params.put("number", endereco.getNumber());
	    params.put("city", endereco.getCity());
	    params.put("zipcode", endereco.getZipcode());
	    params.put("key", apiKey);
	    
	    restTemplate = new RestTemplate();
	    
	    String result = restTemplate.getForObject(API_GOOGLE, String.class, params);
	    
	    ApiGeocodingResponses apiGeocodingResponses =  mapperObjetUtil.doMapperObjet(result, ApiGeocodingResponses.class); 
	    
	    restTemplate = null;
	   
		return apiGeocodingResponses;
		
	}
	
}
