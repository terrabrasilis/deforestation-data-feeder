/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.terrabrasilis.redis.feeder.repository;

import info.terrabrasilis.redis.feeder.domain.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jether
 */
@Repository
public interface ConfigRepository extends JpaRepository<Config, String> {
    
}
