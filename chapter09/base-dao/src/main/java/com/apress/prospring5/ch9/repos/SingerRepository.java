package com.apress.prospring5.ch9.repos;

import com.apress.prospring5.ch9.entities.Singer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SingerRepository extends CrudRepository<Singer, Long> {

    // 不用默认的 count 是因为 count 已经设置好事务了。
    @Query("select count(s) from Singer s")
    Long countAllSingers();

}
