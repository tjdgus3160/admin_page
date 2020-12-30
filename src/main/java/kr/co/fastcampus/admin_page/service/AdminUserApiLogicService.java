package kr.co.fastcampus.admin_page.service;

import kr.co.fastcampus.admin_page.controller.ifs.CrudInterface;
import kr.co.fastcampus.admin_page.model.entity.AdminUser;
import kr.co.fastcampus.admin_page.model.entity.OrderGroup;
import kr.co.fastcampus.admin_page.model.network.Header;
import kr.co.fastcampus.admin_page.model.network.request.AdminUserApiRequest;
import kr.co.fastcampus.admin_page.model.network.response.AdminUserApiResponse;
import kr.co.fastcampus.admin_page.model.network.response.OrderGroupApiResponse;
import kr.co.fastcampus.admin_page.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserApiLogicService implements CrudInterface<AdminUserApiRequest, AdminUserApiResponse> {

    @Autowired
    AdminUserRepository adminUserRepository;

    @Override
    public Header<AdminUserApiResponse> create(Header<AdminUserApiRequest> request) {

        AdminUserApiRequest body = request.getData();

        AdminUser adminUser = AdminUser.builder()
                .account(body.getAccount())
                .password(body.getPassword())
                .status(body.getStatus())
                .role(body.getRole())
                .loginFailCount(0)
                .build();

        AdminUser newAdminUser = adminUserRepository.save(adminUser);

        return response(newAdminUser);
    }

    @Override
    public Header<AdminUserApiResponse> read(Long id) {

        return adminUserRepository.findById(id)
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> request) {

        AdminUserApiRequest body = request.getData();

        return adminUserRepository.findById(body.getId())
                .map(adminUser -> {
                    adminUser
                            .setAccount(body.getAccount())
                            .setPassword(body.getPassword())
                            .setStatus(body.getStatus())
                            .setRole(body.getRole())
                            .setLoginFailCount(body.getLoginFailCount())
                            ;
                    return adminUser;
                })
                .map(adminUser -> adminUserRepository.save(adminUser))
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터 없음"));

    }

    @Override
    public Header delete(Long id) {
        return adminUserRepository.findById(id)
                .map(adminUser -> {
                    adminUserRepository.delete(adminUser);
                    return Header.OK();
                })
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    private Header<AdminUserApiResponse> response(AdminUser adminUser){

        AdminUserApiResponse body = AdminUserApiResponse.builder()
                .id(adminUser.getId())
                .account(adminUser.getAccount())
                .password(adminUser.getPassword())
                .status(adminUser.getStatus())
                .role(adminUser.getRole())
                .loginFailCount(adminUser.getLoginFailCount())
                .build();

        return Header.OK(body);
    }
}
