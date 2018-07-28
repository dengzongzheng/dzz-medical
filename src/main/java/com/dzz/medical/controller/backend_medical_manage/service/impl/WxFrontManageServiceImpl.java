package com.dzz.medical.controller.backend_medical_manage.service.impl;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.controller.backend_medical_manage.dao.SsMedicalLegalMapper;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalLegalDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalLegalListBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.AddMedicalLegalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalLegalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalLegalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.model.SsMedicalLegal;
import com.dzz.medical.controller.backend_medical_manage.service.WxFrontManageService;
import com.dzz.medical.controller.util.service.BaseService;
import com.dzz.medical.controller.util.service.IdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信前台管理接口实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月22 下午9:11
 */
@Service
public class WxFrontManageServiceImpl implements WxFrontManageService,BaseService {

    @Autowired
    private SsMedicalLegalMapper ssMedicalLegalMapper;

    @Autowired
    private IdService idService;


    @Override
    public Boolean saveLegal(AddMedicalLegalDTO addLegalDTO) {

        SsMedicalLegal ssMedicalLegal = SsMedicalLegal.newInstance();
        BeanUtils.copyProperties(addLegalDTO, ssMedicalLegal);
        ssMedicalLegal.setId(idService.getId());
        ssMedicalLegal.setMedicalLegalNo(idService.getFormatId("ML"));
        return ssMedicalLegalMapper.insert(ssMedicalLegal) > 0;
    }

    @Override
    public PageUtil<MedicalLegalListBO> listMedicalLegal(MedicalLegalListQueryDTO query) {

        query.setPageSize(pageSizeHandler(query.getPageSize()));
        query.setPageNo(pageNoHandler(query.getPageNo()));
        PageHelper.startPage(query.getPageNo(), query.getPageSize(), true);
        List<MedicalLegalListBO> legalListBOS = ssMedicalLegalMapper.listMedicalLegal(query);
        PageInfo<MedicalLegalListBO> pageInfo = new PageInfo<>(legalListBOS);
        PageUtil<MedicalLegalListBO> pageUtil = new PageUtil<>();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setData(legalListBOS);
        pageUtil.setTotalPage(pageInfo.getPages());
        return pageUtil;
    }

    @Override
    public Boolean updateStatus(String medicalLegalNo, Integer status) {

        return ssMedicalLegalMapper.updateStatus(medicalLegalNo, status) > 0;
    }

    @Override
    public Boolean updateMedicalLegal(UpdateMedicalLegalDTO updateMedicalLegalDTO) {

        SsMedicalLegal ssMedicalLegal = SsMedicalLegal.newInstance();
        ssMedicalLegal.setCreateTime(null);
        BeanUtils.copyProperties(updateMedicalLegalDTO, ssMedicalLegal);
        return ssMedicalLegalMapper.updateByPrimaryKey(ssMedicalLegal)>0;
    }

    @Override
    public MedicalLegalDetailBO detailMedicalLegal(String medicalLegalNo) {

        return ssMedicalLegalMapper.detailMedicalLegal(medicalLegalNo);
    }
}
