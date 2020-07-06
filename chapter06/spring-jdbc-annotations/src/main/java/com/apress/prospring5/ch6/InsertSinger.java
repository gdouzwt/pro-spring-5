package com.apress.prospring5.ch6;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class InsertSinger extends SqlUpdate {
    private static final String SQL_INSERT_SINGER =
        "INSERT INTO SINGER (FIRST_NAME, LAST_NAME, BIRTH_DATE) VALUES (:first_name, :last_name, :birth_date)";

    public InsertSinger(DataSource dataSource) {
        super(dataSource, SQL_INSERT_SINGER);
        super.declareParameter(new SqlParameter("FIRST_NAME", Types.VARCHAR));
        super.declareParameter(new SqlParameter("LAST_NAME", Types.VARCHAR));
        super.declareParameter(new SqlParameter("BIRTH_DATE", Types.DATE));
        super.setGeneratedKeysColumnNames("id");
        super.setReturnGeneratedKeys(true);
    }

}
