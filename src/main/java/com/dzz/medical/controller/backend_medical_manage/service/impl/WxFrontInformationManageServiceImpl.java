package com.dzz.medical.controller.backend_medical_manage.service.impl;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.controller.backend_medical_manage.dao.SsMedicalInformationMapper;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalInformationDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalInformationListBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.AddMedicalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalInformationDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.model.SsMedicalInformation;
import com.dzz.medical.controller.backend_medical_manage.service.WxFrontInformationManageService;
import com.dzz.medical.controller.util.service.BaseService;
import com.dzz.medical.controller.util.service.IdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 卫生知识信息接口实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年08月19 上午9:16
 */
@Service
public class WxFrontInformationManageServiceImpl implements WxFrontInformationManageService,BaseService {

    @Autowired
    private SsMedicalInformationMapper ssMedicalInformationMapper;

    @Autowired
    private IdService idService;


    @Override
    public Boolean saveInformation(AddMedicalDTO addInformationDTO) {

        SsMedicalInformation ssMedicalInformation = SsMedicalInformation.newInstance();
        BeanUtils.copyProperties(addInformationDTO, ssMedicalInformation);
        ssMedicalInformation.setId(idService.getId());
        ssMedicalInformation.setInformationNo(idService.getFormatId("MN"));
        return ssMedicalInformationMapper.insert(ssMedicalInformation) > 0;
    }

    @Override
    public PageUtil<MedicalInformationListBO> listMedicalInformation(MedicalListQueryDTO query) {

        query.setPageSize(pageSizeHandler(query.getPageSize()));
        query.setPageNo(pageNoHandler(query.getPageNo()));
        PageHelper.startPage(query.getPageNo(), query.getPageSize(), true);
        List<MedicalInformationListBO> legalListBOS = ssMedicalInformationMapper.listMedicalInformation(query);
        PageInfo<MedicalInformationListBO> pageInfo = new PageInfo<>(legalListBOS);
        PageUtil<MedicalInformationListBO> pageUtil = new PageUtil<>();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setData(legalListBOS);
        pageUtil.setTotalPage(pageInfo.getPages());
        return pageUtil;
    }

    @Override
    public Boolean updateStatus(String medicalInformationNo, Integer status) {

        return ssMedicalInformationMapper.updateStatus(medicalInformationNo, status) > 0;
    }

    @Override
    public Boolean updateMedicalInformation(UpdateMedicalInformationDTO updateMedicalInformationDTO) {

        SsMedicalInformation ssMedicalInformation = SsMedicalInformation.newInstance();
        ssMedicalInformation.setCreateTime(null);
        BeanUtils.copyProperties(updateMedicalInformationDTO, ssMedicalInformation);
        ssMedicalInformation.setId(Long.valueOf(updateMedicalInformationDTO.getId()));
        return ssMedicalInformationMapper.updateByPrimaryKeySelective(ssMedicalInformation)>0;
    }

    @Override
    public MedicalInformationDetailBO detailMedicalInformation(String medicalInformationNo) {

        return ssMedicalInformationMapper.detailMedicalInformation(medicalInformationNo);
    }
}
