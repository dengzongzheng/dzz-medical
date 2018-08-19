package com.dzz.medical.controller.frontend_medical.service.impl;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.controller.backend_medical_manage.dao.SsMedicalLegalMapper;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalLegalDetailBO;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListLegalBO;
import com.dzz.medical.controller.frontend_medical.domain.dto.ListQueryDTO;
import com.dzz.medical.controller.frontend_medical.service.ServiceForYouService;
import com.dzz.medical.controller.util.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 为您服务接口实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月28 下午6:43
 */
@Service
public class ServiceForYouServiceImpl implements ServiceForYouService,BaseService{

    @Autowired
    private SsMedicalLegalMapper ssMedicalLegalMapper;

    @Override
    public PageUtil<ListLegalBO> listLegal(ListQueryDTO query) {

        query.setPageSize(pageSizeHandler(query.getPageSize()));
        query.setPageNo(pageNoHandler(query.getPageNo()));
        PageHelper.startPage(query.getPageNo(), query.getPageSize(), true);
        List<ListLegalBO> legalListBOS = ssMedicalLegalMapper.listLegal(query);
        PageInfo<ListLegalBO> pageInfo = new PageInfo<>(legalListBOS);
        PageUtil<ListLegalBO> pageUtil = new PageUtil<>();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setData(legalListBOS);
        pageUtil.setTotalPage(pageInfo.getPages());
        return pageUtil;
    }

    @Override
    public MedicalLegalDetailBO detailMedicalLegal(String medicalLegalNo) {

        return ssMedicalLegalMapper.detailMedicalLegal(medicalLegalNo);
    }
}
