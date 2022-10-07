package sizhe.chen.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sizhe.chen.bean.Car2;

import java.util.HashSet;
import java.util.Set;

/**
 * MainApplication
 *
 * @Author chensizhe
 * @Date 2022/10/3 3:16 PM
 */
@SpringBootApplication(scanBasePackages = {"sizhe.chen.controller", "sizhe.chen.config","sizhe.chen.bean"})
public class MainApplication {


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MainApplication.class);
        Set<String> set = new HashSet<>();
        set.add("classpath:/confg.xml");
        application.setSources(set);
        ConfigurableApplicationContext context = application.run(args);
        //   context.refresh();
        System.out.println(context.getBean("xiaoBai"));
        System.out.println(context.getBean("user01"));
        System.out.println(context.getBean("user"));
        System.out.println(context.getBean("pet"));
        System.out.println(context.getBean("car"));
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println(context.getBean(Car2.class));
    }
}
