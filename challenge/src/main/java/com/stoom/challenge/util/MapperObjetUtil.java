package com.stoom.challenge.util;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;


@Component
public class MapperObjetUtil {
	
	public <T> T doMapperObjet(String json, Class<T> c) {
		return 	new Gson().fromJson(json, c); 
	}

}
