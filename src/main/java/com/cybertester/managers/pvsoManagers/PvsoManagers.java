package com.cybertester.managers.pvsoManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PvsoManagers {

    private final JdbcTemplate jdbcTemplate;

    public PvsoManagers(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void deleteDxRegistr(String guidInput) {

        jdbcTemplate.update("DELETE FROM FSBS.DX_REGISTR WHERE GUID_INPUT = ?", guidInput);
    }

}
