package com.jc_gomis.cards.services.impl;

import com.jc_gomis.cards.constants.CardsConstants;
import com.jc_gomis.cards.domaine.Cards;
import com.jc_gomis.cards.dtos.CardsDto;
import com.jc_gomis.cards.exceptions.CardAllReadyExistException;
import com.jc_gomis.cards.exceptions.ResourceNotFoundException;
import com.jc_gomis.cards.mappers.CardMapper;
import com.jc_gomis.cards.repositories.CardRepository;
import com.jc_gomis.cards.services.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardService implements ICardService {
    @Autowired
    CardRepository cardRepository;
    /**
     *
     * Param mobile number of the Customer
     *
     * @param mobileNumber
     */
    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> cards = cardRepository.findByMobileNumber(mobileNumber);
        if (cards.isPresent()) {
            throw new CardAllReadyExistException("Card already exist");
        }
        cardRepository.save(createNewCard(mobileNumber));
    }
    /**
     * @param mobileNumber - Mobile Number of the Customer
     * @return the new card details
     */
    private Cards createNewCard(String mobileNumber){
        Cards newCard = new Cards();
        long randomCardNumber =  100000000L + new Random().nextLong(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    /**
     *
     * @param mobileNumber - Input mobile Number
     * @return Card Details based on a given mobileNumber
     */
    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Cards cards = cardRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Cards", "mobileNumber", mobileNumber));
        return CardMapper.mapToCardsDto(cards, new CardsDto());
    }



    /**
     *
     * @param cardsDto - CardsDto Object
     * @return boolean indicating if the update of card details is successful or not
     */
    @Override
    public boolean updateCard(CardsDto cardsDto) {
        Cards cards = cardRepository.findByCardNumber(cardsDto.getCardNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Cards", "mobileNumber", cardsDto.getMobileNumber()));

        CardMapper.mapToCards(cardsDto, cards);
        cardRepository.save(cards);
        return true;
    }

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of card details is successful or not
     */
    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards cards = cardRepository.findByCardNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Cards", "mobileNumber", mobileNumber));
        cardRepository.deleteById(cards.getCardId());
        return true;
    }
}
