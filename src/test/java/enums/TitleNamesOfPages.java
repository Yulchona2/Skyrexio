package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TitleNamesOfPages {
    PRODUCTS("Products"), CART("Your Cart"), CHECKOUT_INFORMATION("Checkout: Your Information"), CHECKOUT_OVERVIEW("Checkout: Overview");

    private final String displayName;
}
