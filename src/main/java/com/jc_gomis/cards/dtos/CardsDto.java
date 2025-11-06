package com.jc_gomis.cards.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(name = "CARDS",
    description = "Schema to hold Card information"
)
@Data
public class CardsDto {
    @NotEmpty(message = "Mobile Number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 dgits")
    @Schema(
            description = "Mobile number of customer", example = "0601020304"
    )
    private String mobileNumber;
    @NotEmpty(message = "Card number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Card number must be 12 digits-")
    @Schema(
            description = "Card number of the customer", example = "012132435465"
    )
    private String cardNumber;
    @NotEmpty(message = "Card type can not be empty or null ")
    @Schema(
            description = "Type of card ",example = "Credit card"
    )
    private String cardType;
    @Positive(message = "Total card limit should be greater than zero")
    @Schema(
            description = "Total amount limit available against a card", example = "100000"
    )
    private int totalLimit;
    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")
    @Schema(
            description = "Total amount used by a customer", example = "1000"
    )
    private int amountUsed;
    @PositiveOrZero(
            message = "Total available amount should be equal or greater than zero"
    )
    @Schema(
            description = "Total available amount against a card", example = "90000"
    )
    private int availableAmount;
}
