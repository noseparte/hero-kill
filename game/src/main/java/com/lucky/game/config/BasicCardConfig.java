package com.lucky.game.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BasicCardConfig {

    @Id
    private String id;

    private String name;

    private String image;

    /**
     * 使用时机
     */
    private List<String> user_time = new ArrayList<>();
    /**
     * 使用目标
     */
    private List<String> use_target = new ArrayList<>();
    /**
     * 使用效果
     */
    private List<String> use_effect = new ArrayList<>();
    /**
     * 补充说明
     */
    private String more_info;

}
