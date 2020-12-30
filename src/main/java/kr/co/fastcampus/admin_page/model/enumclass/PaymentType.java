package kr.co.fastcampus.admin_page.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentType {

    CARD(0,"카드"),
    CASH(1,"현금"),
    ;
    private Integer id;
    private String title;
}
