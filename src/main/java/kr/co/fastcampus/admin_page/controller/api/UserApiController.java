package kr.co.fastcampus.admin_page.controller.api;

import kr.co.fastcampus.admin_page.controller.CrudController;
import kr.co.fastcampus.admin_page.model.entity.User;
import kr.co.fastcampus.admin_page.model.network.Header;
import kr.co.fastcampus.admin_page.model.network.request.UserApiRequest;
import kr.co.fastcampus.admin_page.model.network.response.UserApiResponse;
import kr.co.fastcampus.admin_page.model.network.response.UserOrderInfoApiResponse;
import kr.co.fastcampus.admin_page.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User> {

    @Autowired
    UserApiLogicService userApiLogicService;

    @GetMapping("/{id}/orderInfo")
    public Header<UserOrderInfoApiResponse> orderInfo(@PathVariable Long id){
        return userApiLogicService.orderInfo(id);
    }

    @GetMapping("")
    public Header<List<UserApiResponse>> search(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 10) Pageable pageable){
        log.info("{}",pageable);
        return baseService.search(pageable);
    }
}
