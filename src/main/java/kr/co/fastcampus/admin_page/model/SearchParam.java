package kr.co.fastcampus.admin_page.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchParam {

    private String account;
    private String email;
    private int page;

    // { "account" : "", "email" : "", "page" : 0}
}
