package com.web.common.config.properties;

import java.io.IOException;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

/**
 * 自定义属性加载器
 * 
 * @author Administrator
 *
 */
public class MyPropertiesSourceFactory implements PropertySourceFactory{

	public MyPropertiesSourceFactory() {
	}
	
	@Override
	public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
		// TODO Auto-generated method stub
		return new YamlPropertySourceLoader().load(name, resource.getResource()).get(0);
	}

}
