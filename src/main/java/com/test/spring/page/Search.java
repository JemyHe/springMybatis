package com.test.spring.page;

import java.util.Map;

/**
 * Created by 何冠雄 on 2018/2/8.
 */
public class Search {

    private int page; //当前第几页

    private int rows;//一页多少行

    private int firstRows;//当前页开始的第一个元素下标

    private Map<String,Object> params;//查询参数

    /**
     * 当前页数开始的第一个元素下标
     * @param page
     * @param rows
     * @return
     */
    public int getFirstRows(int page,int rows){
        return (page-1)*rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Search() {
    }

    public Search(int page, int rows, Map<String, Object> params) {
        this.page = page;
        this.rows = rows;
        this.firstRows = getFirstRows(page,rows);
        this.params = params;
    }
}
