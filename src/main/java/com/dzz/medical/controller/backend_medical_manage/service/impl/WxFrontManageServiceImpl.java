package com.dzz.medical.controller.backend_medical_manage.service.impl;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.controller.backend_medical_manage.dao.SsMedicalLegalMapper;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalLegalListBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.AddMedicalLegalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalLegalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.model.SsMedicalLegal;
import com.dzz.medical.controller.backend_medical_manage.service.WxFrontManageService;
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
public class WxFrontManageServiceImpl implements WxFrontManageService {

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
    public PageUtil<MedicalLegalListBO> listMedicalLegal(MedicalLegalListQueryDTO queryDTO) {

        if (0 > queryDTO.getPageNo()) {
            queryDTO.setPageNo(1);
        }
        if (queryDTO.getPageSize() > 100) {
            queryDTO.setPageSize(10);
        }
        PageHelper.startPage(queryDTO.getPageNo(), queryDTO.getPageSize(), true);
        List<MedicalLegalListBO> legalListBOS = ssMedicalLegalMapper.listMedicalLegal(queryDTO);
        PageInfo<MedicalLegalListBO> pageInfo = new PageInfo<>(legalListBOS);
        PageUtil<MedicalLegalListBO> pageUtil = new PageUtil<>();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setData(legalListBOS);
        pageUtil.setTotalPage(pageInfo.getPages());
        return pageUtil;
    }
}
