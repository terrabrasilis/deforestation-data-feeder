/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.terrabrasilis.redis.feeder.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author jether
 */
@Entity
@Table(name = "config")
public class Config implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "key", unique=true)
    private final String key;
    @Lob
    @Column(name = "value", columnDefinition="clob")
    private final String value;

    /**
     * To framework use in reflection
     */
    public Config() {
        this.key = null;
        this.value = null;
    }
    
    private Config(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static Config of(String key, String value) {
        return new Config(key, value);
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.key);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Config other = (Config) obj;
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Config{" + "key=" + key + ", value=" + value + '}';
    }
}
