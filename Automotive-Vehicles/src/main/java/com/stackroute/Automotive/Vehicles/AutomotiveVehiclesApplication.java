package com.stackroute.Automotive.Vehicles;

import com.stackroute.Automotive.Vehicles.filter.JWTFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class AutomotiveVehiclesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomotiveVehiclesApplication.class, args);
	}


	@Bean
	public FilterRegistrationBean beanFilter() {
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new JWTFilter());
		frb.addUrlPatterns(
				"/vehicle-app/*",
                 "/admin/*");
//				"/vehicle-app/get-user-details",//get-user
//				"/vehicle-app/add-vehicle-to-user", //add vehicle
//				"/admin/vehicle-app/add-new-vehicle",//add-vehicle
//				"/vehicle-app/admin/delete-vehicle/",//delete-vehicle
//				"/vehicle-app/get-vehicle",
//				"/admin/get-all-vehicles");
//				"/vehicle-app/admin/update-vehicle",
//				"/vehicle-app/admin/delete-from-cart/*",
//				"/vehicle-app/get-user-vehicle");// get vehicle from logged user **
		return frb;

	}
		@Bean
		public FilterRegistrationBean filterRegistrationBean () {
			final CorsConfiguration config = new CorsConfiguration();
			config.setAllowCredentials(true);
			config.addAllowedOrigin("http://localhost:9999");
			config.addAllowedHeader("*");
			config.addAllowedMethod("*");
			final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", config);
			FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
			bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
			return bean;
		}
	}
