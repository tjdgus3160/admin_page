package kr.co.fastcampus.admin_page.controller.api;

import kr.co.fastcampus.admin_page.controller.CrudController;
import kr.co.fastcampus.admin_page.model.entity.Category;
import kr.co.fastcampus.admin_page.model.network.request.CategoryApiRequest;
import kr.co.fastcampus.admin_page.model.network.response.CategoryApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryApiController extends CrudController<CategoryApiRequest, CategoryApiResponse, Category> {

}
