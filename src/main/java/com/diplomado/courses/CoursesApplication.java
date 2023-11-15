package com.diplomado.courses;

import com.diplomado.courses.domain.entities.Student;
import com.diplomado.courses.repositories.StudentRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@SpringBootApplication
public class CoursesApplication implements ApplicationRunner {
	private static final Logger log = LoggerFactory.getLogger((CoursesApplication.class));

	private final StudentRepository studentRepository;

	public CoursesApplication(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication springApplication= new SpringApplication(CoursesApplication.class);
		logApplicationStarup(springApplication.run(args).getEnvironment());
	}

	private static void logApplicationStarup(Environment env) {
		String protocol = Optional.ofNullable(env.getProperty("server.ssl.key-store"))
				.map(key -> "https")
				.orElse("http");
		String serverPort = env.getProperty("server.port");
		String contextPath = Optional
				.ofNullable(env.getProperty("server.servlet.context-path"))
				.filter(StringUtils::isNotBlank)
				.orElse("/");
		String hostAddress = "localhost";

		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.warn("The host name could not be determined, using 'localhost' as fallback");
		}

		log.info(
				"\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Local: \t\t{}://localhost:{}{}\n\t" +
						"External: \t{}://{}:{}{}\n\t" +
						"Profile(s): \t{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				protocol,
				serverPort,
				contextPath,
				protocol,
				hostAddress,
				serverPort,
				contextPath,
				env.getActiveProfiles()
		);
		for (int i=0; i<1000 ; i++){

		}
		for (int i=0; i<1000 ; i++){

		}
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		studentRepository.save(new Student("Rigo","Ledezma","rigo@gmail.com", 28));
	}
}
