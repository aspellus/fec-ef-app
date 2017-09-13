package com.salientcrgt.ezamendment.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "results")
public class ResponseList {
    private List<Object> list;

    /**
     * constructor
     */
    public ResponseList() {

    }

    /**
     * @return list
     */
    public List<Object> getList() {
        return list;
    }

    /**
     * @param list list
     */
    public void setList(List<Object> list) {
        this.list = list;
    }
}
