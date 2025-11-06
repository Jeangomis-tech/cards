package com.jc_gomis.cards.mappers;

import com.jc_gomis.cards.domaine.Cards;
import com.jc_gomis.cards.dtos.CardsDto;



public class CardMapper {

    public static Cards mapToCards( CardsDto cardsDto, Cards cards) {

        cards.setCardNumber( cardsDto.getCardNumber() );
        cards.setCardType( cardsDto.getCardType() );
        cards.setAmountUsed( cardsDto.getAmountUsed() );
        cards.setAvailableAmount( cardsDto.getAvailableAmount() );
        cards.setMobileNumber( cardsDto.getMobileNumber() );
        cards.setTotalLimit( cardsDto.getTotalLimit() );

        return cards;
    }

    public static  CardsDto mapToCardsDto( Cards cards, CardsDto cardsDto) {
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());
        cardsDto.setMobileNumber(cards.getMobileNumber());
        cardsDto.setTotalLimit( cards.getTotalLimit() );
        return cardsDto;

    }

}
