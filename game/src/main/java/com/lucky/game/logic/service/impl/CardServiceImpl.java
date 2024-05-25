package com.lucky.game.logic.service.impl;

import com.lucky.game.entity.PlayerEntity;
import com.lucky.game.entity.RoomEntity;
import com.lucky.game.logic.service.CardService;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    /**
     * 刷新牌库
     * @param sceneType 几人场
     */
    @Override
    public void refreshDeck(SceneType sceneType) {

    }

    /**
     * 发牌
     * @param room
     */
    @Override
    public void dealCards(RoomEntity room) {

    }

    @Override
    public void playCard(RoomEntity room, PlayerEntity player) {

    }
}
