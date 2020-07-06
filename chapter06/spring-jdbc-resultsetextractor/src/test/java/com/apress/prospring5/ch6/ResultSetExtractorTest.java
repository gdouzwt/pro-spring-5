package com.apress.prospring5.ch6;

import com.apress.prospring5.ch6.config.NamedJdbcCfg;
import com.apress.prospring5.ch6.dao.SingerDao;
import com.apress.prospring5.ch6.entities.Album;
import com.apress.prospring5.ch6.entities.Singer;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by iuliana.cosmina on 4/16/17.
 */
public class ResultSetExtractorTest {

    @Test
    public void testResultSetExtractor() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(NamedJdbcCfg.class);
        SingerDao singerDao = ctx.getBean(SingerDao.class);
        assertNotNull(singerDao);
        List<Singer> singers = singerDao.findAllWithAlbums();
        assertEquals(3, singers.size());
        singers.forEach(singer -> {
            System.out.println(singer);
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    System.out.println("\t--> " + album);
                }
                if (singer.getId() == 1L) {
                    assertEquals(2, singer.getAlbums().size());
                } else if (singer.getId() == 2L) {
                    assertEquals(1, singer.getAlbums().size());
                } else if (singer.getId() == 3L) {
                    assertEquals(0, singer.getAlbums().size());
                }
            }
        });
        ctx.close();
    }
}
