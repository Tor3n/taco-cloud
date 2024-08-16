package taco.taco_cloud;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import taco.taco_cloud.components.Taco;

import java.util.ArrayList;
import java.util.List;

@Data
public class TacoOrder {
    @NotBlank(message="Delivery name is required")
    private String deliveryName;

    @NotBlank(message="street name is required")
    private String deliveryStreet;

    @NotBlank(message="city name is required")
    private String deliveryCity;

    @NotBlank(message="state is required")
    private String deliveryState;

    @NotBlank(message="zip is required")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card Number")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco){
        this.tacos.add(taco);
    }
}
