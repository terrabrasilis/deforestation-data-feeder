/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.terrabrasilis.redis.feeder.service;

import info.terrabrasilis.redis.feeder.domain.Config;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jether
 */
@Service
public class ConfigService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired private DSLContext dsl;
	
    public List<Config> findAll() {
        String sql = "SELECT \"key\", \"value\" FROM public.config WHERE key='prodes_cerrado#uf'";
        
        return dsl.fetch(sql).stream()
                    .map(rs -> Config.of((String) rs.get("key"), (String) rs.get("value")))
                    .collect(Collectors.toList());
    }
}
