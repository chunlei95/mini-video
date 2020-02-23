package com.video.common.page;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * @author xzmeasy
 * @since 2020/2/23
 */
@Data
public class PageResult<T> {

    private Integer pageNum;

    private Integer pageSize;

    private Long totalCount;

    private Integer totalPage;

    private Boolean isFirstPage;

    private Boolean isLastPage;

    private List<T> data;

    private PageResult(PageInfo<T> pageInfo) {
        this.totalPage = pageInfo.getPages();
        this.isLastPage = pageInfo.isIsLastPage();
        this.isFirstPage = pageInfo.isIsFirstPage();
        this.totalCount = pageInfo.getTotal();
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.data = pageInfo.getList();
    }

    public static <T> PageResult<T> from(PageInfo<T> pageInfo) {
        return new PageResult<>(pageInfo);
    }


}
