/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.terrabrasilis.redis.feeder.vo;

import java.io.Serializable;

/**
 *
 * @author jether
 */
public class FilterVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final Integer id;
    private final String type;

    private FilterVO(Integer id, String type) {
        this.id = id;
        this.type = type;
    }
    
    public static final FilterVO of(Integer id, String type) {
        return new FilterVO(id, type);
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
