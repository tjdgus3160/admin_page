package kr.co.fastcampus.admin_page.controller.api;

import kr.co.fastcampus.admin_page.controller.ifs.CrudInterface;
import kr.co.fastcampus.admin_page.model.network.Header;
import kr.co.fastcampus.admin_page.model.network.request.PartnerApiRequest;
import kr.co.fastcampus.admin_page.model.network.response.PartnerApiResponse;
import kr.co.fastcampus.admin_page.service.PartnerApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController implements CrudInterface<PartnerApiRequest, PartnerApiResponse> {

    @Autowired
    PartnerApiLogicService partnerApiLogicService;

    @Override
    @PostMapping("")
    public Header<PartnerApiResponse> create(@RequestBody Header<PartnerApiRequest> request) {
        return partnerApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<PartnerApiResponse> read(@PathVariable Long id) {
        return partnerApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<PartnerApiResponse> update(@RequestBody Header<PartnerApiRequest> request) {
        return partnerApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return partnerApiLogicService.delete(id);
    }
}
