package com.dzz.medical.common.mybatis;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author dzz
 * @since 2016年11月28 下午5:45
 * @version 1.0.0
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
