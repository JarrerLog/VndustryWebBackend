package com.vndustrybackend.vndustrybackend;

import com.vndustrybackend.vndustrybackend.Handlers.MindustryHandler.ResourceUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static com.vndustrybackend.vndustrybackend.Vars.*;

@SpringBootApplication
public class VndustrybackendApplication {

	public static void main(String[] args) {
		cache.delete();

		dataDirectory.mkdirs();
		cache.mkdirs();
		resources.mkdirs();
		sprites.mkdirs();
		data.mkdirs();
		schematicSave.mkdirs();
		mapSave.mkdirs();

		ResourceUtils.init();
		SpringApplication.run(VndustrybackendApplication.class, args);
	}

}
