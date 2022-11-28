package org.polytech.covidapi;

import org.apache.catalina.core.ApplicationContext;
import org.polytech.covidapi.entity.Patient;
import org.polytech.covidapi.service.AppConfig;
import org.polytech.covidapi.service.PatientService;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class CovidApiApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CovidApiApplication.class, args);

		try (AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
			PatientService patientService = ctx.getBean(PatientService.class);

			Patient aPatient = new Patient( );
			patientService.savePatient(aPatient);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
