/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento;

/**
 *
 * @author David
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author David
 */
@Configuration
@ComponentScan("pe.edu.upeu")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter  {
@Override
public void addCorsMappings(CorsRegistry registry) {
registry.addMapping("/**")
                .allowedOrigins("http://localhost:8383")
                .allowedMethods("POST", "GET",  "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("X-Auth-Token", "Content-Type")
                .exposedHeaders("custom-header1", "custom-header2")
                .allowCredentials(false)
                .maxAge(4800);
}
}