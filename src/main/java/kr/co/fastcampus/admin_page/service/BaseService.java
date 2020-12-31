package kr.co.fastcampus.admin_page.service;

import kr.co.fastcampus.admin_page.ifs.CrudInterface;
import kr.co.fastcampus.admin_page.model.network.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class BaseService<Req,Res,Entity> implements CrudInterface<Req,Res> {

    @Autowired(required = false)
    protected JpaRepository<Entity,Long> baseRepository;

    public abstract Header<List<Res>> search(Pageable pageable);
}
