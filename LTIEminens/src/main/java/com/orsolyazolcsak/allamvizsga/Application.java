package com.orsolyazolcsak.allamvizsga;

import com.orsolyazolcsak.allamvizsga.util.ReadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {


    private final ReadFile readFile;

    @Autowired
    public Application(ReadFile readFile) {

        this.readFile = readFile;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {

        readFile.readTestData();
    }
}
