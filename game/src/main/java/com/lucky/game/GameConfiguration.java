package com.lucky.game;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: Noseparte
 * @Date: 2020/1/8 15:14
 * @Description:
 *
 *         <p></p>
 */
@Data
@Component
@ConfigurationProperties(prefix = "game")
public class GameConfiguration {

    public int poolSize;

}
