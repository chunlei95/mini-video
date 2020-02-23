package com.video.common.page;

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

    private Integer totalCount;

    private Integer totalPage;

    private Boolean isFirstPage;

    private Boolean isLastPage;

    private List<T> data;

    private PageResult(int pageNum, int pageSize, Integer totalCount, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.data = data;
        totalPage = totalCount / pageSize;
        if (totalCount % pageSize != 0) {
            totalPage += 1;
        }
        isFirstPage = pageNum == 1;
        isLastPage = (totalCount <= pageSize && pageNum == 1) || (totalPage == pageSize) || (totalPage == 0);
    }

    public static <T> PageResult<T> from(int pageNum, int pageSize, Integer totalCount, List<T> data) {
        return new PageResult<>(pageNum, pageSize, totalCount, data);
    }

}
