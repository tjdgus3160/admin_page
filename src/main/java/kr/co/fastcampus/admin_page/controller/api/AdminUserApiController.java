package kr.co.fastcampus.admin_page.controller.api;

import kr.co.fastcampus.admin_page.controller.ifs.CrudInterface;
import kr.co.fastcampus.admin_page.model.network.Header;
import kr.co.fastcampus.admin_page.model.network.request.AdminUserApiRequest;
import kr.co.fastcampus.admin_page.model.network.response.AdminUserApiResponse;
import kr.co.fastcampus.admin_page.service.AdminUserApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController implements CrudInterface<AdminUserApiRequest, AdminUserApiResponse> {

    @Autowired
    AdminUserApiLogicService adminUserApiLogicService;

    @Override
    @PostMapping("")
    public Header<AdminUserApiResponse> create(@RequestBody Header<AdminUserApiRequest> request) {
        return adminUserApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<AdminUserApiResponse> read(@PathVariable Long id) {
        return adminUserApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<AdminUserApiResponse> update(@RequestBody Header<AdminUserApiRequest> request) {
        return adminUserApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return adminUserApiLogicService.delete(id);
    }
}
