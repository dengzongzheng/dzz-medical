package com.dzz.medical.controller.backend_medical_manage.service.impl;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.controller.backend_medical_manage.dao.SsMedicalWorkNewsMapper;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalWorkNewsDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalWorkNewsListBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.AddMedicalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalWorkNewsDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.model.SsMedicalWorkNews;
import com.dzz.medical.controller.backend_medical_manage.service.WxFrontWorkNewsManageService;
import com.dzz.medical.controller.util.service.BaseService;
import com.dzz.medical.controller.util.service.IdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 动态信息接口实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年08月19 上午9:16
 */
@Service
public class WxFrontWorkNewsManageServiceImpl implements WxFrontWorkNewsManageService,BaseService {

    @Autowired
    private SsMedicalWorkNewsMapper ssMedicalWorkNewsMapper;

    @Autowired
    private IdService idService;


    @Override
    public Boolean saveWorkNews(AddMedicalDTO addWorkNewsDTO) {

        SsMedicalWorkNews ssMedicalWorkNews = SsMedicalWorkNews.newInstance();
        BeanUtils.copyProperties(addWorkNewsDTO, ssMedicalWorkNews);
        ssMedicalWorkNews.setId(idService.getId());
        ssMedicalWorkNews.setWorkNewsNo(idService.getFormatId("MN"));
        return ssMedicalWorkNewsMapper.insert(ssMedicalWorkNews) > 0;
    }

    @Override
    public PageUtil<MedicalWorkNewsListBO> listMedicalWorkNews(MedicalListQueryDTO query) {

        query.setPageSize(pageSizeHandler(query.getPageSize()));
        query.setPageNo(pageNoHandler(query.getPageNo()));
        PageHelper.startPage(query.getPageNo(), query.getPageSize(), true);
        List<MedicalWorkNewsListBO> legalListBOS = ssMedicalWorkNewsMapper.listMedicalWorkNews(query);
        PageInfo<MedicalWorkNewsListBO> pageInfo = new PageInfo<>(legalListBOS);
        PageUtil<MedicalWorkNewsListBO> pageUtil = new PageUtil<>();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setData(legalListBOS);
        pageUtil.setTotalPage(pageInfo.getPages());
        return pageUtil;
    }

    @Override
    public Boolean updateStatus(String medicalWorkNewsNo, Integer status) {

        return ssMedicalWorkNewsMapper.updateStatus(medicalWorkNewsNo, status) > 0;
    }

    @Override
    public Boolean updateMedicalWorkNews(UpdateMedicalWorkNewsDTO updateMedicalWorkNewsDTO) {

        SsMedicalWorkNews ssMedicalWorkNews = SsMedicalWorkNews.newInstance();
        ssMedicalWorkNews.setCreateTime(null);
        BeanUtils.copyProperties(updateMedicalWorkNewsDTO, ssMedicalWorkNews);
        ssMedicalWorkNews.setId(Long.valueOf(updateMedicalWorkNewsDTO.getId()));
        return ssMedicalWorkNewsMapper.updateByPrimaryKeySelective(ssMedicalWorkNews)>0;
    }

    @Override
    public MedicalWorkNewsDetailBO detailMedicalWorkNews(String medicalWorkNewsNo) {

        return ssMedicalWorkNewsMapper.detailMedicalWorkNews(medicalWorkNewsNo);
    }
}
