package br.com.codenation.centralerrosapi;

import br.com.codenation.centralerrosapi.dto.UserCreateDTO;
import br.com.codenation.centralerrosapi.model.Log;
import br.com.codenation.centralerrosapi.model.LogApplication;
import br.com.codenation.centralerrosapi.model.LogDetail;
import br.com.codenation.centralerrosapi.model.enums.Environment;
import br.com.codenation.centralerrosapi.model.enums.Level;
import br.com.codenation.centralerrosapi.repository.LogRepository;
import br.com.codenation.centralerrosapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InvalidObjectException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CentralErrosApiApplication implements CommandLineRunner {

	@Autowired
	private LogRepository logRepository;

    @Autowired
    private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(CentralErrosApiApplication.class, args);
	}

	@Override
    public void run(String... args) throws InvalidObjectException {

        UserCreateDTO dto = UserCreateDTO.builder().username("admin").password("password").build();
        System.out.println("User saved: " + userService.save(dto));

		LocalDateTime timestamp = LocalDateTime.now();

        LogApplication application = LogApplication.builder()
				.name("central-api-rest")
				.ip("127.0.0.1")
				.host("java-client-test")
				.environment(Environment.DEVELOPMENT)
				.build();

		List<Log> logs = new ArrayList<Log>();
		for (int i = 0; i < 25; i++) {
            LogDetail detail = LogDetail.builder().timestamp(timestamp).level(Level.ERROR).content("Detalhe do log " + i).build();
            Log log = Log.builder().title("Título do log " + i).application(application).detail(detail).archived(false).build();
			logs.add(log);
		}

		logRepository.saveAll(logs);

	}
}
