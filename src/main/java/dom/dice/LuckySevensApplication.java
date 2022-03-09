package dom.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LuckySevensApplication implements CommandLineRunner {

	@Autowired
	private User user;

	public static void main(String[] args) {
		SpringApplication.run(LuckySevensApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		user.welcome();
		user.userInput();
	}
}
