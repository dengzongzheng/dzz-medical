package com.dzz.medical.controller.wx_manage.domain.model.custom.message.news;

import java.util.List;
import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class News {
	
	/** 多条图文消息信息, 图文消息条数限制在8条以内, 注意, 如果图文数超过8, 则将会无响应 */
	private List<Article> articles;
}