package com.apress.prospring5.ch6.dao;

import com.apress.prospring5.ch6.*;
import com.apress.prospring5.ch6.entities.Album;
import com.apress.prospring5.ch6.entities.Singer;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("singerDao")
public class JdbcSingerDao implements SingerDao {

    private static Logger logger = LoggerFactory.getLogger(JdbcSingerDao.class);
    private DataSource dataSource;
    private SelectAllSingers selectAllSingers;
    private SelectSingerByFirstName selectSingerByFirstName;
    private UpdateSinger updateSinger;
    private InsertSinger insertSinger;
    private InsertSingerAlbum insertSingerAlbum;
    private DeleteSinger deleteSinger;
    private StoredFunctionFirstNameById storedFunctionFirstNameById;

    @Override
    public List<Singer> findAll() {
        return selectAllSingers.execute();
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("FIRST_NAME", firstName);
        return selectSingerByFirstName.executeByNamedParam(paramMap);
    }

    @Override
    public String findFirstNameById(Long id) {
        List<String> result = storedFunctionFirstNameById.execute(id);
        return result.get(0);
    }

    @Override
    public void insert(Singer singer) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("FIRST_NAME", singer.getFirstName());
        paramMap.put("LAST_NAME", singer.getLastName());
        paramMap.put("BIRTH_DATE", singer.getBirthDate());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertSinger.updateByNamedParam(paramMap, keyHolder);
        singer.setId(keyHolder.getKey().longValue());
        logger.info("New singer inserted with id: " + singer.getId());
    }

    @Override
    public void insertWithAlbum(Singer singer) {
        insertSingerAlbum = new InsertSingerAlbum(dataSource);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("FIRST_NAME", singer.getFirstName());
        paramMap.put("LAST_NAME", singer.getLastName());
        paramMap.put("BIRTH_DATE", singer.getBirthDate());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertSinger.updateByNamedParam(paramMap, keyHolder);
        singer.setId(keyHolder.getKey().longValue());
        logger.info("New singer inserted with id: " + singer.getId());
        List<Album> albums =
            singer.getAlbums();
        if (albums != null) {
            for (Album album : albums) {
                paramMap = new HashMap<>();
                paramMap.put("SINGER_ID", singer.getId());
                paramMap.put("TITLE", album.getTitle());
                paramMap.put("RELEASE_DATE", album.getReleaseDate());
                insertSingerAlbum.updateByNamedParam(paramMap);
            }
        }
        insertSingerAlbum.flush();
    }

    @Override
    public List<Singer> findAllWithAlbums() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String sql = "SELECT s.id, s.first_name, s.last_name, s.birth_date" +
            ", a.id AS album_id, a.title, a.release_date FROM SINGER s " +
            "LEFT JOIN ALBUM a ON s.id = a.singer_id";
        return jdbcTemplate.query(sql, rs -> {
            Map<Long, Singer> map = new HashMap<>();
            Singer singer;
            while (rs.next()) {
                Long id = rs.getLong("ID");
                singer = map.get(id);
                if (singer == null) {
                    singer = new Singer();
                    singer.setId(id);
                    singer.setFirstName(rs.getString("FIRST_NAME"));
                    singer.setLastName(rs.getString("LAST_NAME"));
                    singer.setBirthDate(rs.getDate("BIRTH_DATE"));
                    singer.setAlbums(new ArrayList<>());
                    map.put(id, singer);
                }
                long albumId = rs.getLong("ALBUM_ID");
                if (albumId > 0) {
                    Album album = new Album();
                    album.setId(albumId);
                    album.setSingerId(id);
                    album.setTitle(rs.getString("TITLE"));
                    album.setReleaseDate(rs.getDate("RELEASE_DATE"));
                    singer.getAlbums().add(album);
                }
            }
            return new ArrayList<>(map.values());
        });
    }

    @Override
    public void update(Singer singer) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("FIRST_NAME", singer.getFirstName());
        paramMap.put("LAST_NAME", singer.getLastName());
        paramMap.put("BIRTH_DATE", singer.getBirthDate());
        paramMap.put("ID", singer.getId());
        updateSinger.updateByNamedParam(paramMap);
        logger.info("Existing singer updated with id: " + singer.getId());
    }

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllSingers = new SelectAllSingers(dataSource);
        this.selectSingerByFirstName = new SelectSingerByFirstName(dataSource);
        this.updateSinger = new UpdateSinger(dataSource);
        this.insertSinger = new InsertSinger(dataSource);
        this.storedFunctionFirstNameById = new StoredFunctionFirstNameById(dataSource);
        this.deleteSinger = new DeleteSinger(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public String findNameById(Long id) {
        throw new NotImplementedException("findNameById");
    }

    @Override
    public String findLastNameById(Long id) {
        throw new NotImplementedException("findLastNameById");
    }

    @Override
    public void delete(Long singerId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ID", singerId);
        deleteSinger.updateByNamedParam(paramMap);
        logger.info("Deleting singer with id: " + singerId);
    }
}
