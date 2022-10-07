package sizhe.chen.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sizhe.chen.bean.Car2;
import sizhe.chen.bean.Pet;
import sizhe.chen.bean.User;

/**
 * MyConfig
 *
 * @Author chensizhe
 * @Date 2022/10/3 8:30 PM
 */
@Configuration
@EnableConfigurationProperties(Car2.class)
public class MyConfig {

    @Bean
    public User user01(){
        User user = new User();
        user.setName("李四");
        user.setAge(23);
        return user;
    }
    @Bean
    public Pet xiaoBai(){
        Pet pet = new Pet();
        pet.setName("小虎");
        return pet;
    }
}
