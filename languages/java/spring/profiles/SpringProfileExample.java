package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// application.properties content => output
// spring.profiles.active=p1      => S1 S4
// spring.profiles.active=p2      => S1 S3
@SpringBootApplication
public class SpringProfileExample {
    public static void main(String[] args) {
        SpringApplication.run(SpringProfileExample.class, args);
    }
}

@Component
class Sout1 {
    public Sout1() {
        System.out.print("S1 ");
    }
}

class Sout2 {
    public Sout2() {
        System.out.print("S2 ");
    }
}

@Profile("p2")
@Component
class Sout3 {
    public Sout3() {
        System.out.print("S3 ");
    }
}

class Sout4 {
    public Sout4() {
        System.out.print("S4 ");
    }
}

class Sout5 {
    public Sout5() {
        System.out.print("S5 ");
    }
}

@Profile("p1")
@Configuration
class Conf {
    @Bean
    /*
    If we have 'p2' active then configuration class which declares this bean will not be picked at all
     */
    @Profile("p2")
    public Sout2 sout2() {
        return new Sout2();
    }

    /*
    This one will work with 'p1' profile active
     */
    @Bean
    @Profile("p1")
    public Sout4 sout4() {
        return new Sout4();
    }
}
