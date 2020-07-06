package com.apress.prospring5.ch6;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class InsertSingerAlbum extends BatchSqlUpdate {
    private static final String SQL_INSERT_SINGER_ALBUM =
        "INSERT INTO ALBUM (SINGER_ID, TITLE, RELEASE_DATE) VALUES (:SINGER_ID, :TITLE, :RELEASE_DATE)";

    private static final int BATCH_SIZE = 10;

    public InsertSingerAlbum(DataSource dataSource) {
        super(dataSource, SQL_INSERT_SINGER_ALBUM);

        declareParameter(new SqlParameter("SINGER_ID", Types.INTEGER));
        declareParameter(new SqlParameter("TITLE", Types.VARCHAR));
        declareParameter(new SqlParameter("RELEASE_DATE", Types.DATE));

        setBatchSize(BATCH_SIZE);
    }
}
