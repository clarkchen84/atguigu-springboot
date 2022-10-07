package sizhe.chen.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * User
 *
 * @Author chensizhe
 * @Date 2022/10/3 8:20 PM
 */
@Data
public class User {
    private String name;
    private int age;
}
