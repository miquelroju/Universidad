package com.example.zooapi;

import com.example.zooapi.application.Controller;
import com.example.zooapi.utilities.ConstantUtilities;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZooApiApplication {

    public ZooApiApplication(Controller controller) throws Exception {
        controller.createAnimalsTest(ConstantUtilities.TUNA);
        controller.createAnimalsTest(ConstantUtilities.ELEPHAN);
        controller.createAnimalsTest(ConstantUtilities.CROCODILE);
        controller.createAnimalsTest(ConstantUtilities.EAGLE);
        controller.createAnimalsTest(ConstantUtilities.DOLPHIN);
    }

    public static void main(String[] args) {
        SpringApplication.run(ZooApiApplication.class, args);
    }

}
