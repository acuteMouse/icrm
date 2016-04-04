package com.cgl.util;

/**
 * Created cgl on 2016/4/4.
 * 类名：
 * 作用：分页
 */
public class Page {
    private int page; //页数，第几页,hibernate需要的是从0开始，页面传来的+1
    private int rows;//一页多少行

    public Page(int page, int rows) {
        this.page = page;
        this.rows = rows;
    }

    public Page() {
        
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
}
