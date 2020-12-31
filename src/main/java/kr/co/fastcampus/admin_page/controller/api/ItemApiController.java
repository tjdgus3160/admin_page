package kr.co.fastcampus.admin_page.controller.api;

import kr.co.fastcampus.admin_page.controller.CrudController;
import kr.co.fastcampus.admin_page.model.entity.Item;
import kr.co.fastcampus.admin_page.model.network.request.ItemApiRequest;
import kr.co.fastcampus.admin_page.model.network.response.ItemApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

}
