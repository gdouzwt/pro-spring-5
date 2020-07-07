package com.apress.prospring5.ch6;

import com.apress.prospring5.ch6.dao.SingerDao;
import com.apress.prospring5.ch6.entities.Album;
import com.apress.prospring5.ch6.entities.Singer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * Created by iuliana.cosmina on 4/16/17.
 * Observation: before running these tests make sure to have the MySQL database in the initial state defined in the SQL scripts
 */
//@Ignore
// 这个数据库测试，应该Rollback的，但是没有，所以运行第二次的时候，就会有冲突，有重复的外键
//FixMe: 到时候改进一下。 现在先忽略
public class AnnotationJdbcTest {

    private GenericXmlApplicationContext ctx;
    private SingerDao singerDao;

    @BeforeEach
    public void setUp() {
//        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx = new GenericXmlApplicationContext();
        //ctx.load("classpath:spring/drivermanager-cfg-01.xml");
        //ctx.load("classpath:spring/drivermanager-cfg-02.xml");
        ctx.load("classpath:spring/datasource-dbcp.xml");
        ctx.refresh();
        singerDao = ctx.getBean(SingerDao.class);
        assertNotNull(singerDao);
    }

    @Test
//    @Disabled
    public void testFindAll() {
        List<Singer> singers = singerDao.findAll();
        assertEquals(3, singers.size());
        listSingers(singers);
        ctx.close();
    }

    @Test
//    @Disabled
    public void testFindByFirstName() {
        List<Singer> singers = singerDao.findByFirstName("John");
        assertEquals(1, singers.size());
        listSingers(singers);
        ctx.close();
    }

    @Test
//    @Disabled
    public void testSingerUpdate() {
        Singer singer = new Singer();
        singer.setId(1L);
        singer.setFirstName("John Clayton");
        singer.setLastName("Mayer");
        singer.setBirthDate(new Date(
            (new GregorianCalendar(1977, 9, 16)).getTime().getTime()));
        singerDao.update(singer);

        List<Singer> singers = singerDao.findAll();
        listSingers(singers);
    }

    @Test
//    @Disabled
    public void testSingerInsert() {
        Singer singer = new Singer();
        singer.setFirstName("Ed");
        singer.setLastName("Sheeran");
        singer.setBirthDate(new Date(
            (new GregorianCalendar(1991, 1, 17)).getTime().getTime()));
        singerDao.insert(singer);

        List<Singer> singers = singerDao.findAll();
        listSingers(singers);
    }

    @Test
//    @Disabled
    public void testSingerInsertWithAlbum() {
        Singer singer = new Singer();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(new Date(
            (new GregorianCalendar(1940, 8, 16)).getTime().getTime()));

        Album album = new Album();
        album.setTitle("My Kind of Blues");
        album.setReleaseDate(new Date(
            (new GregorianCalendar(1961, 7, 18)).getTime().getTime()));
        singer.addAlbum(album);

        album = new Album();
        album.setTitle("A Heart Full of Blues");
        album.setReleaseDate(new Date(
            (new GregorianCalendar(1962, 3, 20)).getTime().getTime()));
        singer.addAlbum(album);

        singerDao.insertWithAlbum(singer);

        List<Singer> singers = singerDao.findAllWithAlbums();
        listSingers(singers);
    }

    @Test
//    @Disabled
    public void testFindFirstNameById() {
        String firstName = singerDao.findFirstNameById(2L);
        assertEquals("Eric", firstName);
        System.out.println("Retrieved value: " + firstName);
    }


    private void listSingers(List<Singer> singers) {
        singers.forEach(singer -> {
            System.out.println(singer);
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    System.out.println("\t--> " + album);
                }
            }
        });
    }

    @AfterEach
    public void tearDown() {
        ctx.close();
    }
}
