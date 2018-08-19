package com.dzz.medical.controller.backend_medical_manage.service.impl;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.controller.backend_medical_manage.dao.SsMedicalNoticeMapper;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalNoticeDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalNoticeListBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.AddMedicalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalNoticeDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.model.SsMedicalNotice;
import com.dzz.medical.controller.backend_medical_manage.service.WxFrontNoticeManageService;
import com.dzz.medical.controller.util.service.BaseService;
import com.dzz.medical.controller.util.service.IdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 通知信息接口实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年08月19 上午9:16
 */
@Service
public class WxFrontNoticeManageServiceImpl implements WxFrontNoticeManageService,BaseService {

    @Autowired
    private SsMedicalNoticeMapper ssMedicalNoticeMapper;

    @Autowired
    private IdService idService;


    @Override
    public Boolean saveNotice(AddMedicalDTO addNoticeDTO) {

        SsMedicalNotice ssMedicalNotice = SsMedicalNotice.newInstance();
        BeanUtils.copyProperties(addNoticeDTO, ssMedicalNotice);
        ssMedicalNotice.setId(idService.getId());
        ssMedicalNotice.setNoticeNo(idService.getFormatId("MN"));
        return ssMedicalNoticeMapper.insert(ssMedicalNotice) > 0;
    }

    @Override
    public PageUtil<MedicalNoticeListBO> listMedicalNotice(MedicalListQueryDTO query) {

        query.setPageSize(pageSizeHandler(query.getPageSize()));
        query.setPageNo(pageNoHandler(query.getPageNo()));
        PageHelper.startPage(query.getPageNo(), query.getPageSize(), true);
        List<MedicalNoticeListBO> legalListBOS = ssMedicalNoticeMapper.listMedicalNotice(query);
        PageInfo<MedicalNoticeListBO> pageInfo = new PageInfo<>(legalListBOS);
        PageUtil<MedicalNoticeListBO> pageUtil = new PageUtil<>();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setData(legalListBOS);
        pageUtil.setTotalPage(pageInfo.getPages());
        return pageUtil;
    }

    @Override
    public Boolean updateStatus(String medicalNoticeNo, Integer status) {

        return ssMedicalNoticeMapper.updateStatus(medicalNoticeNo, status) > 0;
    }

    @Override
    public Boolean updateMedicalNotice(UpdateMedicalNoticeDTO updateMedicalNoticeDTO) {

        SsMedicalNotice ssMedicalNotice = SsMedicalNotice.newInstance();
        ssMedicalNotice.setCreateTime(null);
        BeanUtils.copyProperties(updateMedicalNoticeDTO, ssMedicalNotice);
        ssMedicalNotice.setId(updateMedicalNoticeDTO.getId());
        return ssMedicalNoticeMapper.updateByPrimaryKeySelective(ssMedicalNotice)>0;
    }

    @Override
    public MedicalNoticeDetailBO detailMedicalNotice(String medicalNoticeNo) {

        return ssMedicalNoticeMapper.detailMedicalNotice(medicalNoticeNo);
    }
}
