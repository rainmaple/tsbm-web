package cn.edu.ruc.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
public class WebConfigBeans {
	@Autowired
	private RequestMappingHandlerAdapter handlerAdapter;
	@PostConstruct
	public void initConverter() {
		
		ConfigurableWebBindingInitializer init = (ConfigurableWebBindingInitializer)handlerAdapter.getWebBindingInitializer();
		if(init.getConversionService()!=null) {
			GenericConversionService service = (GenericConversionService)init.getConversionService();
			service.addConverter(new StringToDateConverter());
		}
		
	}
}
