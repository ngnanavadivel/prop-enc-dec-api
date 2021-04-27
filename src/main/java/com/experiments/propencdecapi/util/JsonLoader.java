package com.experiments.propencdecapi.util;

import java.io.IOException;
import java.util.Map;

import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonLoader implements PropertySourceFactory {

	@Override
	public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> propsMap = mapper.readValue(resource.getReader(), new TypeReference<Map<String, Object>>() {
		});
		return new MapPropertySource("json-properties-" + name, propsMap);
	}

}
