package com.dzz.medical.controller.util.service;

/**
 * 基础接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月28 下午6:55
 */
public interface BaseService {

    Integer PAGE_SIZE = 10;

    /**
     * 处理每页大小
     * @param pageSize 当前每页条数
     * @return 处理过后的每页条娄
     */
    default Integer pageSizeHandler(Integer pageSize) {
        if (0 > pageSize||pageSize>30) {
            return PAGE_SIZE;
        }else{
            return pageSize;
        }
    }

    /**
     * 处理页码
     * @param pageNo 当前页码
     * @return 处理结果
     */
    default Integer pageNoHandler(Integer pageNo) {

        if (0 > pageNo) {
            return 1;
        }else{
            return pageNo;
        }
    }
}