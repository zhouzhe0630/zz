package cn.invitation.entity;

import java.util.List;

public class Page<T> {
    private int pageNo;
    private int pageSize;
    private int pageCount;
    private int count;
    private List<T> pageList;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count == 0)
            this.count = 1;
        else
            this.count = count;
        this.pageCount = this.count % this.pageSize == 0 ? this.count / this.pageSize : this.count / this.pageSize + 1;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }
}
