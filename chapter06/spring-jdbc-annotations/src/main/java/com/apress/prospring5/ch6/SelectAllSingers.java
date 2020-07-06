package com.apress.prospring5.ch6;

import com.apress.prospring5.ch6.entities.Singer;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllSingers extends MappingSqlQuery<Singer> {
    private static final String SQL_SELECT_ALL_SINGER =
        "SELECT ID, FIRST_NAME, LAST_NAME, BIRTH_DATE FROM SINGER";

    public SelectAllSingers(DataSource dataSource) {
        super(dataSource, SQL_SELECT_ALL_SINGER);
    }

    protected Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Singer singer = new Singer();

        singer.setId(rs.getLong("ID"));
        singer.setFirstName(rs.getString("FIRST_NAME"));
        singer.setLastName(rs.getString("LAST_NAME"));
        singer.setBirthDate(rs.getDate("BIRTH_DATE"));

        return singer;
    }
}
