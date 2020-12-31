package kr.co.fastcampus.admin_page.controller.api;

import kr.co.fastcampus.admin_page.controller.CrudController;
import kr.co.fastcampus.admin_page.model.entity.OrderGroup;
import kr.co.fastcampus.admin_page.model.network.request.OrderGroupApiRequest;
import kr.co.fastcampus.admin_page.model.network.response.OrderGroupApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

}
