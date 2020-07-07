package com.apress.prospring5.ch6;

import com.apress.prospring5.ch6.config.NamedJdbcCfg;
import com.apress.prospring5.ch6.dao.SingerDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by iuliana.cosmina on 4/16/17.
 */
public class NamedJdbcCfgTest {

    @Test
    public void testCfg() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(NamedJdbcCfg.class);

        SingerDao singerDao = ctx.getBean(SingerDao.class);
        assertNotNull(singerDao);
        String singerName = singerDao.findNameById(1L);
        assertEquals("John Mayer", singerName);

        ctx.close();
    }

}
