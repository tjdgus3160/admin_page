package kr.co.fastcampus.admin_page.service;

import kr.co.fastcampus.admin_page.model.entity.Category;
import kr.co.fastcampus.admin_page.model.network.Header;
import kr.co.fastcampus.admin_page.model.network.request.CategoryApiRequest;
import kr.co.fastcampus.admin_page.model.network.response.CategoryApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryApiLogicService extends BaseService<CategoryApiRequest, CategoryApiResponse,Category> {

    @Override
    public Header<CategoryApiResponse> create(Header<CategoryApiRequest> request) {

        CategoryApiRequest body = request.getData();

        Category category = Category.builder()
                .type(body.getType())
                .title(body.getTitle())
                .build();

        Category newCategory = baseRepository.save(category);

        return response(newCategory);
    }

    @Override
    public Header<CategoryApiResponse> read(Long id) {

        return baseRepository.findById(id)
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<CategoryApiResponse> update(Header<CategoryApiRequest> request) {

        CategoryApiRequest body = request.getData();

        return baseRepository.findById(body.getId())
                .map(category -> {
                    category
                            .setType(body.getType())
                            .setTitle(body.getTitle())
                            ;
                    return category;
                })
                .map(category -> baseRepository.save(category))
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
                .map(category -> {
                    baseRepository.delete(category);
                    return Header.OK();
                })
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    private Header<CategoryApiResponse> response(Category category){

        CategoryApiResponse body = CategoryApiResponse.builder()
                .id(category.getId())
                .type(category.getType())
                .title(category.getTitle())
                .build();
        return Header.OK(body);
    }

    @Override
    public Header<List<CategoryApiResponse>> search(Pageable pageable) {
        return null;
    }
}
