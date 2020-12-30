package kr.co.fastcampus.admin_page.service;

import jdk.javadoc.internal.doclets.formats.html.markup.Head;
import kr.co.fastcampus.admin_page.controller.ifs.CrudInterface;
import kr.co.fastcampus.admin_page.model.entity.Partner;
import kr.co.fastcampus.admin_page.model.network.Header;
import kr.co.fastcampus.admin_page.model.network.request.PartnerApiRequest;
import kr.co.fastcampus.admin_page.model.network.response.PartnerApiResponse;
import kr.co.fastcampus.admin_page.repository.CategoryRepository;
import kr.co.fastcampus.admin_page.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PartnerApiLogicService implements CrudInterface<PartnerApiRequest, PartnerApiResponse> {

    @Autowired
    PartnerRepository partnerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Header<PartnerApiResponse> create(Header<PartnerApiRequest> request) {

        PartnerApiRequest body = request.getData();

        Partner partner = Partner.builder()
                .name(body.getName())
                .status(body.getStatus())
                .address(body.getAddress())
                .callCenter(body.getCallCenter())
                .partnerNumber(body.getPartnerNumber())
                .businessNumber(body.getBusinessNumber())
                .ceoName(body.getCeoName())
                .registeredAt(LocalDateTime.now())
                .category(categoryRepository.getOne(body.getCategoryId()))
                .build();

        Partner newPartner = partnerRepository.save(partner);

        return response(newPartner);
    }

    @Override
    public Header<PartnerApiResponse> read(Long id) {

        return partnerRepository.findById(id)
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<PartnerApiResponse> update(Header<PartnerApiRequest> request) {

        PartnerApiRequest body = request.getData();

        return partnerRepository.findById(body.getId())
                .map(partner -> {
                    partner
                            .setName(body.getName())
                            .setStatus(body.getStatus())
                            .setAddress(body.getAddress())
                            .setCallCenter(body.getCallCenter())
                            .setPartnerNumber(body.getPartnerNumber())
                            .setBusinessNumber(body.getBusinessNumber())
                            .setCeoName(body.getCeoName())
                            .setCategory(categoryRepository.getOne(body.getCategoryId()))
                            ;
                    return partner;
                })
                .map(partner -> partnerRepository.save(partner))
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        return partnerRepository.findById(id)
                .map(partner -> {
                    partnerRepository.delete(partner);
                    return Header.OK();
                })
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    private Header<PartnerApiResponse> response(Partner partner){

        PartnerApiResponse body = PartnerApiResponse.builder()
                .id(partner.getId())
                .name(partner.getName())
                .status(partner.getStatus())
                .address(partner.getAddress())
                .callCenter(partner.getCallCenter())
                .partnerNumber(partner.getPartnerNumber())
                .businessNumber(partner.getBusinessNumber())
                .ceoName(partner.getCeoName())
                .registeredAt(partner.getRegisteredAt())
                .categoryId(partner.getCategory().getId())
                .build();

        return Header.OK(body);
    }
}
