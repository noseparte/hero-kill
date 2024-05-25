package com.lucky.game.logic.service;

import com.lucky.game.entity.PlayerEntity;
import com.lucky.game.entity.RoomEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author haoyitao
 * @since 2024/5/25 - 14:32
 * @version 1.0
 * @implSpec
 */
public interface CardService {

    // 洗牌
    void refreshDeck(SceneType sceneType);

    // 发牌
    void dealCards(RoomEntity room);

    // 出牌
    void playCard(RoomEntity room, PlayerEntity player);

    //

    @Getter
    @AllArgsConstructor
    enum SceneType{
        Three(3, "3v3"),
        FIVE(5, "5P"),
        Eight(8, "8P"),
        ;

        final int num;
        final String shortName;

    }
}
