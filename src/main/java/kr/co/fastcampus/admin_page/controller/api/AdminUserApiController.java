package kr.co.fastcampus.admin_page.controller.api;

import kr.co.fastcampus.admin_page.controller.CrudController;
import kr.co.fastcampus.admin_page.model.entity.AdminUser;
import kr.co.fastcampus.admin_page.model.network.request.AdminUserApiRequest;
import kr.co.fastcampus.admin_page.model.network.response.AdminUserApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController extends CrudController<AdminUserApiRequest, AdminUserApiResponse, AdminUser> {

}
