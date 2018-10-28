package org.sc.service.myb.util;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class AppPage<T> {
    private Integer pageSize;  // 一页多少行
    private Integer pageNum; // 当前页
    private Integer totalPage;   // 总页数
    private Long totalElements;  // 总数
    private T param;
    private List<T> content = new ArrayList<T>(); // 内容

    public AppPage() {
    }

    public AppPage(AppPage page) {
        this.pageSize = page.getPageSize();
        this.pageNum = page.getPageNum();
        this.totalPage = page.getTotalPage();
        this.totalElements = page.getTotalElements();
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }



    public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public T getParam() {
		return param;
	}

	public void setParam(T param) {
		this.param = param;
	}

	public boolean hasContent() {
        return !CollectionUtils.isEmpty(this.content);
    }
}