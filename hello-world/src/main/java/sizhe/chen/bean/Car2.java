package sizhe.chen.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Car
 *
 * @Author chensizhe
 * @Date 2022/10/4 8:13 AM
 */
@ConfigurationProperties(prefix = "my-car")
@Data
public class Car2 {
    private  String brand;
    private String color;
}
