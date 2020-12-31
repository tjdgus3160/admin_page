package kr.co.fastcampus.admin_page.ifs;

import kr.co.fastcampus.admin_page.model.network.Header;
import kr.co.fastcampus.admin_page.model.network.request.UserApiRequest;

public interface CrudInterface<Req,Res> {

    Header<Res> create(Header<Req> request);    // todo request object 추가

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);
}
