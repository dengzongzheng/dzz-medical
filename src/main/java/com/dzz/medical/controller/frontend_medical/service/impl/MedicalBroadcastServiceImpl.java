package com.dzz.medical.controller.frontend_medical.service.impl;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.controller.backend_medical_manage.dao.SsMedicalInformationMapper;
import com.dzz.medical.controller.backend_medical_manage.dao.SsMedicalNoticeMapper;
import com.dzz.medical.controller.backend_medical_manage.dao.SsMedicalWorkNewsMapper;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalInformationDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalNoticeDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalWorkNewsDetailBO;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListInformationBO;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListNoticeBO;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListWorkNewsBO;
import com.dzz.medical.controller.frontend_medical.domain.dto.ListQueryDTO;
import com.dzz.medical.controller.frontend_medical.service.MedicalBroadcastService;
import com.dzz.medical.controller.util.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 卫监播报
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年08月19 上午11:23
 */
@Service
@Slf4j
public class MedicalBroadcastServiceImpl implements MedicalBroadcastService,BaseService {

    @Autowired
    private SsMedicalNoticeMapper ssMedicalNoticeMapper;


    @Autowired
    private SsMedicalInformationMapper ssMedicalInformationMapper;


    @Autowired
    private SsMedicalWorkNewsMapper ssMedicalWorkNewsMapper;

    @Override
    public PageUtil<ListNoticeBO> listNotice(ListQueryDTO query) {

        query.setPageSize(pageSizeHandler(query.getPageSize()));
        query.setPageNo(pageNoHandler(query.getPageNo()));
        PageHelper.startPage(query.getPageNo(), query.getPageSize(), true);
        List<ListNoticeBO> listNoticeBOS = ssMedicalNoticeMapper.listNotice(query);
        PageInfo<ListNoticeBO> pageInfo = new PageInfo<>(listNoticeBOS);
        PageUtil<ListNoticeBO> pageUtil = new PageUtil<>();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setData(listNoticeBOS);
        pageUtil.setTotalPage(pageInfo.getPages());
        return pageUtil;
    }

    @Override
    public MedicalNoticeDetailBO detailMedicalNotice(String medicalNoticeNo) {

        return ssMedicalNoticeMapper.detailMedicalNotice(medicalNoticeNo);
    }

    @Override
    public PageUtil<ListInformationBO> listInformation(ListQueryDTO query) {

        query.setPageSize(pageSizeHandler(query.getPageSize()));
        query.setPageNo(pageNoHandler(query.getPageNo()));
        PageHelper.startPage(query.getPageNo(), query.getPageSize(), true);
        List<ListInformationBO> informationBOS = ssMedicalInformationMapper.listInformation(query);
        PageInfo<ListInformationBO> pageInfo = new PageInfo<>(informationBOS);
        PageUtil<ListInformationBO> pageUtil = new PageUtil<>();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setData(informationBOS);
        pageUtil.setTotalPage(pageInfo.getPages());
        return pageUtil;
    }

    @Override
    public MedicalInformationDetailBO detailMedicalInformation(String medicalInformationNo) {

        return ssMedicalInformationMapper.detailMedicalInformation(medicalInformationNo);
    }

    @Override
    public PageUtil<ListWorkNewsBO> listWorkNews(ListQueryDTO query) {

        query.setPageSize(pageSizeHandler(query.getPageSize()));
        query.setPageNo(pageNoHandler(query.getPageNo()));
        PageHelper.startPage(query.getPageNo(), query.getPageSize(), true);
        List<ListWorkNewsBO> workNewsBOS = ssMedicalWorkNewsMapper.listWorkNews(query);
        PageInfo<ListWorkNewsBO> pageInfo = new PageInfo<>(workNewsBOS);
        PageUtil<ListWorkNewsBO> pageUtil = new PageUtil<>();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setData(workNewsBOS);
        pageUtil.setTotalPage(pageInfo.getPages());
        return pageUtil;
    }

    @Override
    public MedicalWorkNewsDetailBO detailMedicalWorkNews(String medicalWorkNewsNo) {

        return ssMedicalWorkNewsMapper.detailMedicalWorkNews(medicalWorkNewsNo);
    }
}
