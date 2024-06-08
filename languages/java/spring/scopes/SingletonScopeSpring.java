package com.spring.cheatsheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SingletonScopeSpring
{
	public static void main(String[] args)
	{
		ConfigurableApplicationContext ctx = SpringApplication.run(SingletonScopeSpring.class, args);
		Container container = (Container) ctx.getBean("container");
		System.out.println(container.sc1() == container.sc2()); // true
		System.out.println(container.pc1() == container.pc2()); // false
	}
}

@Component
record Container(SingletonComponent sc1, SingletonComponent sc2, PrototypeComponent pc1, PrototypeComponent pc2) {}

@Component
class SingletonComponent {}

@Component
@Scope("prototype")
class PrototypeComponent {}