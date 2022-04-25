package dayonglee.benepicture;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(basePackageClasses = BenepictureApplication.class)
@SpringBootApplication
public class BenepictureApplication {

	public static void main(String[] args) {
		SpringApplication.run(BenepictureApplication.class, args);
	}

}
