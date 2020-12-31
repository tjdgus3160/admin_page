package kr.co.fastcampus.admin_page.service;

import kr.co.fastcampus.admin_page.model.entity.AdminUser;
import kr.co.fastcampus.admin_page.model.network.Header;
import kr.co.fastcampus.admin_page.model.network.request.AdminUserApiRequest;
import kr.co.fastcampus.admin_page.model.network.response.AdminUserApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserApiLogicService extends BaseService<AdminUserApiRequest, AdminUserApiResponse,AdminUser> {

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

        AdminUser newAdminUser = baseRepository.save(adminUser);

        return response(newAdminUser);
    }

    @Override
    public Header<AdminUserApiResponse> read(Long id) {

        return baseRepository.findById(id)
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> request) {

        AdminUserApiRequest body = request.getData();

        return baseRepository.findById(body.getId())
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
                .map(adminUser -> baseRepository.save(adminUser))
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터 없음"));

    }

    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
                .map(adminUser -> {
                    baseRepository.delete(adminUser);
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

    @Override
    public Header<List<AdminUserApiResponse>> search(Pageable pageable) {
        return null;
    }
}
