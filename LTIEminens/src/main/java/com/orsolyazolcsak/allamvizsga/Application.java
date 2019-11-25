package com.orsolyazolcsak.allamvizsga;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orsolyazolcsak.allamvizsga.service.ProblemService;


@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	ProblemService problemService;
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	 @Override
	    public void run(String... arg0) throws Exception {
	        List<String> problems = problemService.getAllProblemsByDifficulty(1);
	        for(String problem : problems)
	        {
	            System.out.println("Easy questions => " + problem);
	        }
	    }
}
