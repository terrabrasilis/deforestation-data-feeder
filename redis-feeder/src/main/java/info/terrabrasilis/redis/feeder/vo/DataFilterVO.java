/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.terrabrasilis.redis.feeder.vo;
import info.terrabrasilis.redis.feeder.domain.Data;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jether
 */
public class DataFilterVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final Data data;
    private final List<FilterVO> filters;

    private DataFilterVO(Data data, List<FilterVO> filters) {
        this.data = data;
        this.filters = filters;
    }
    
    public static final DataFilterVO of(Data data, List<FilterVO> filters) {
        return new DataFilterVO(data, filters);
    }

    public Data getData() {
        return data;
    }

    public List<FilterVO> getFilters() {
        return filters;
    }
}
