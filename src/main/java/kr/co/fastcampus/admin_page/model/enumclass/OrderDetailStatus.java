package kr.co.fastcampus.admin_page.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderDetailStatus {

    COMPLETE(0,"완료","완료 상태"),
    UNCOMPLETE(1,"미완료","미완료 상태"),
    WAITING(2,"대기","대기 상태")
    ;
    private Integer id;
    private String title;
    private String description;
}
