package com.dzz.medical.controller.system.service.impl;


import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.common.response.ResponseDzz;
import com.dzz.medical.controller.system.common.tools.UserAccountUtil;
import com.dzz.medical.controller.system.dao.BsAdminPermitMapper;
import com.dzz.medical.controller.system.dao.BsAdminUserBelongMapper;
import com.dzz.medical.controller.system.dao.BsAdminUserMapper;
import com.dzz.medical.controller.system.dao.BsAdminUserPermitMapper;
import com.dzz.medical.controller.system.dao.BsAdminUserRoleMapper;
import com.dzz.medical.controller.system.domain.bo.AdminUserDetailBO;
import com.dzz.medical.controller.system.domain.bo.BsAdminUserBO;
import com.dzz.medical.controller.system.domain.bo.BsAdminUserBelongBO;
import com.dzz.medical.controller.system.domain.bo.ConfigurableUserBO;
import com.dzz.medical.controller.system.domain.bo.ListUserBO;
import com.dzz.medical.controller.system.domain.bo.PermitBO;
import com.dzz.medical.controller.system.domain.dto.user.BsUserAddDTO;
import com.dzz.medical.controller.system.domain.dto.user.BsUserUpdateDTO;
import com.dzz.medical.controller.system.domain.dto.user.ListUserQueryDTO;
import com.dzz.medical.controller.system.domain.dto.user.UserAuthorizationDTO;
import com.dzz.medical.controller.system.domain.dto.user.UserBelongAddDTO;
import com.dzz.medical.controller.system.domain.dto.user.UserCancellationDTO;
import com.dzz.medical.controller.system.domain.dto.user.UserConfigurationAddDTO;
import com.dzz.medical.controller.system.domain.dto.user.UserPermitDTO;
import com.dzz.medical.controller.system.domain.model.BsAdminUser;
import com.dzz.medical.controller.system.domain.model.BsAdminUserBelong;
import com.dzz.medical.controller.system.domain.model.BsAdminUserPermit;
import com.dzz.medical.controller.system.domain.model.BsAdminUserRole;
import com.dzz.medical.controller.system.service.BsAdminUserService;
import com.dzz.medical.controller.util.service.IdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * 用户接口相关实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月20 下午4:46
 */
@Service
@Slf4j
public class BsAdminUserServiceImpl implements BsAdminUserService {

    @Autowired
    private BsAdminUserMapper bsAdminUserMapper;

    @Autowired
    private BsAdminUserBelongMapper bsAdminUserBelongMapper;

    @Autowired
    private IdService idService;

    @Autowired
    private BsAdminUserRoleMapper bsAdminUserRoleMapper;

    @Autowired
    private BsAdminUserPermitMapper bsAdminUserPermitMapper;

    @Autowired
    private BsAdminPermitMapper bsAdminPermitMapper;

    /**
     * 用户列表查询
     *
     * @param listUserQueryDTO 查询条件
     * @return 用户信息
     */
    @Override
    public ResponseDzz<PageUtil<ListUserBO>> pageListUser(ListUserQueryDTO listUserQueryDTO) {
        PageHelper.startPage(listUserQueryDTO.getPageNo(), listUserQueryDTO.getPageSize(), true);
        List<ListUserBO> list = bsAdminUserMapper.pageListDepartment(listUserQueryDTO);
        PageInfo<ListUserBO> pageInfo = new PageInfo<>(list);
        PageUtil<ListUserBO> pageUtil = new PageUtil();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setData(pageInfo.getList());
        pageUtil.setTotalPage(pageInfo.getPages());
        return ResponseDzz.ok(pageUtil);
    }
    /**
     * 用户列表查询
     * 当前用户所在部门
     * @param listUserQueryDTO 查询条件
     * @return 用户信息
     */
    @Override
    public ResponseDzz<PageUtil<ListUserBO>> pageListUserByDepartment(ListUserQueryDTO listUserQueryDTO,String departmentId){
        PageHelper.startPage(listUserQueryDTO.getPageNo(), listUserQueryDTO.getPageSize(), true);
        List<ListUserBO> list = bsAdminUserMapper.pageListDepartmentId(listUserQueryDTO.getDepartmentName(),
                listUserQueryDTO.getRoleName(),departmentId,listUserQueryDTO.getCurrentUser());
        PageInfo<ListUserBO> pageInfo = new PageInfo<>(list);
        PageUtil<ListUserBO> pageUtil = new PageUtil();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setData(pageInfo.getList());
        pageUtil.setTotalPage(pageInfo.getPages());
        return ResponseDzz.ok(pageUtil);
    }

    /**
     * 新增用户
     *
     * @param userAddDTO 用户新增实体
     * @return 用户id
     */
    @Override
    @Transactional(rollbackFor = {Exception.class, SQLException.class})
    public ResponseDzz<String> addUser(BsUserAddDTO userAddDTO) {
        String userId = idService.getFormatId("yh");
        //保存用户信息
        userAddDTO.setPassword(Md5Crypt.md5Crypt(userAddDTO.getPassword().getBytes(),
                UserAccountUtil.getSaltValue(userAddDTO.getAccount())));
        bsAdminUserMapper.insert(userAddDTO.convertToBsAdminUser(idService.getId(), userId));
        UserBelongAddDTO userBelongAddDTO = userAddDTO.getUserBelongAddDTO();
        userBelongAddDTO.setUserId(userId);
        userBelongAddDTO.setUserCode(userAddDTO.getUserCode());
        Date date = new Date();

        this.saveUserBelong(userBelongAddDTO);
        //保存用户角色信息
        BsAdminUserRole record = new BsAdminUserRole();
        record.setId(idService.getId());
        record.setUserId(userId);
        record.setRoleId(userBelongAddDTO.getRoleId());
        record.setStatus(1);
        record.setUpdateTime(date);
        record.setUpdator(userAddDTO.getUserCode());
        record.setCreateTime(date);
        record.setCreator(userAddDTO.getUserCode());
        bsAdminUserRoleMapper.insert(record);
        return ResponseDzz.ok(userId);
    }

    /**
     * 根据用户id查询权限信息
     *
     * @param userId 用户id
     * @return 权限信息
     */
    @Override
    public ResponseDzz<List<PermitBO>> selectAuthorizeByUserId(String userId) {
        List<String> listPermitId = bsAdminUserPermitMapper.selectByUserId(userId);
        if(!CollectionUtils.isEmpty(listPermitId)){
            List<PermitBO> permitBOS = bsAdminPermitMapper.selectByPermitId(listPermitId);
            return ResponseDzz.ok(permitBOS);
        }
        return ResponseDzz.ok();
    }

    /**
     * 为用户授权
     *
     * @param userAuthorizationDTO 用户授权DTO
     * @return 返回结果
     */
    @Override
    @Transactional(rollbackFor = {Exception.class, SQLException.class})
    public ResponseDzz<String> authorizeUser(UserAuthorizationDTO userAuthorizationDTO) {
        bsAdminUserPermitMapper.deleteByUserId(userAuthorizationDTO.getUserId());
        Date date = new Date();
        for (UserPermitDTO dto : userAuthorizationDTO.getUserPermitDTOList()) {
            BsAdminUserPermit record = new BsAdminUserPermit();
            record.setId(idService.getId());
            record.setUserId(userAuthorizationDTO.getUserId());
            record.setPermitId(dto.getPermitId());
            record.setStatus(1);
            record.setUpdateTime(date);
            record.setUpdator(userAuthorizationDTO.getUserCode());
            record.setCreateTime(date);
            record.setCreator(userAuthorizationDTO.getUserCode());
            bsAdminUserPermitMapper.insert(record);
        }
        return ResponseDzz.ok(userAuthorizationDTO.getUserId());
    }

    /**
     * 通过角色Id查询同级别用户
     *
     * @param roleId 角色id
     * @return 同级别用户信息
     */
    @Override
    public ResponseDzz<List<BsAdminUserBO>> selectUserByRoleId(String roleId) {
        List<BsAdminUserBO> list = bsAdminUserMapper.selectUserByRoleId(roleId);
        return ResponseDzz.ok(list);
    }

    /**
     * 撤销用户
     *
     * @param userCancellationDTO 用户撤销实体
     * @return 撤销结果
     */
    @Override
    @Transactional(rollbackFor = {Exception.class, SQLException.class})
    public ResponseDzz<String> closeUserAccount(UserCancellationDTO userCancellationDTO) {
        //将撤销用户状态置为失效
        String userId = userCancellationDTO.getClosedUserId();
        String userCode = userCancellationDTO.getUserCode();

        bsAdminUserMapper.updateStatus(0, userId, userCode);
        return ResponseDzz.ok(userId);
    }

    /**
     * 根据部门id和角色类型查询其人员
     *
     * @param departmentId 部门id
     * @param roleType     角色类型
     * @return 员工数据
     */
    @Override
    public ResponseDzz<List<BsAdminUserBO>> selectConfigurableUser(String departmentId, Integer roleType) {
        return ResponseDzz.ok(bsAdminUserMapper.listUsersByParam(departmentId, roleType));
    }

    /**
     * 根据部门id和角色类型,用户id查询相关人员
     *
     * @param departmentId 部门id
     * @param roleType     角色类型
     * @param userId       userId
     * @return 员工数据
     */
    @Override
    public ResponseDzz<List<BsAdminUserBelongBO>> selectConfigurableUserBelong(String departmentId, Integer roleType,
                                                                               String userId) {
        List<BsAdminUserBO> list = bsAdminUserMapper.listUsersByParam(departmentId, roleType);
        List<BsAdminUserBelongBO> belongList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(user -> {
                BsAdminUserBelongBO bo=new BsAdminUserBelongBO();
                BeanUtils.copyProperties(user,bo);
                List<BsAdminUserBO> height = bsAdminUserBelongMapper.listBelongByUserId(user.getUserId(),userId);
                List<BsAdminUserBO> low = bsAdminUserBelongMapper.listBelongByUserId(userId,user.getUserId());
                bo.setIsBelong(!CollectionUtils.isEmpty(height)|| !CollectionUtils.isEmpty(low));
                belongList.add(bo);
            });
        }
        return ResponseDzz.ok(belongList);
    }

    /**
     * 根据用户id, 查询其已被配置的上,下级关系人员信息
     *
     * @param userId 用户id
     * @return 上\下级员工数据
     */
    @Override
    public ResponseDzz<ConfigurableUserBO> selectConfiguredUser(String userId) {
        ConfigurableUserBO bo = new ConfigurableUserBO();
        bo.setHigherLevelUsers(bsAdminUserBelongMapper.listHigherLevelUsersByUserId(userId));
        bo.setLowerLevelUsers(bsAdminUserBelongMapper.listLowerLevelUsersByUserId(userId));
        return ResponseDzz.ok(bo);
    }

    /**
     * 保存用户的归属关系配置
     *
     * @param userBelongAddDTO 归属关系配置
     * @return 配置结果
     */
    @Override
    @Transactional(rollbackFor = {Exception.class, SQLException.class})
    public ResponseDzz<String> saveUserAscription(UserBelongAddDTO userBelongAddDTO) {
        Date date = new Date();
        bsAdminUserBelongMapper.deleteAllByUserId(userBelongAddDTO.getUserId());
        this.saveUserBelong(userBelongAddDTO);
        //获取用户角色信息
        BsAdminUserRole bsAdminUserRole = bsAdminUserRoleMapper.getByUserId(userBelongAddDTO.getUserId());
        //角色变更
        if (!Objects.equals(bsAdminUserRole.getRoleId(), userBelongAddDTO.getRoleId())) {
            //删除用户权限
            bsAdminUserPermitMapper.deleteByUserId(userBelongAddDTO.getUserId());
            //更新用户角色
            bsAdminUserRole.setRoleId(userBelongAddDTO.getRoleId());
            bsAdminUserRole.setUpdateTime(date);
            bsAdminUserRole.setUpdator(userBelongAddDTO.getUserCode());
            bsAdminUserRoleMapper.updateByPrimaryKeySelective(bsAdminUserRole);
        }
        return ResponseDzz.ok(userBelongAddDTO.getUserId());
    }

    /**
     * 保存用户上下级关系
     *
     * @param userBelongAddDTO 用户上下级数据
     */
    private void saveUserBelong(UserBelongAddDTO userBelongAddDTO) {


        String userCode = userBelongAddDTO.getUserCode();
        if (!userBelongAddDTO.getHigherLevelUsers().isEmpty()) {
            for (UserConfigurationAddDTO user : userBelongAddDTO.getHigherLevelUsers()) {
                BsAdminUserBelong record = user.convertToBsAdminUserBelong(idService.getId(), userCode);
                record.setUserId(user.getUserId());
                record.setSubordinateId(userBelongAddDTO.getUserId());
                bsAdminUserBelongMapper.insert(record);
            }
        }
        if (!userBelongAddDTO.getLowerLevelUsers().isEmpty()) {
            for (UserConfigurationAddDTO user : userBelongAddDTO.getLowerLevelUsers()) {
                BsAdminUserBelong record = user.convertToBsAdminUserBelong(idService.getId(), userCode);
                record.setUserId(userBelongAddDTO.getUserId());
                record.setSubordinateId(user.getUserId());
                bsAdminUserBelongMapper.insert(record);
            }
        }
    }

    /**
     * 根据邮箱查找用户信息
     *
     * @param mail 邮箱地址
     * @return 配置结果
     */
    @Override
    public ResponseDzz<BsAdminUserBO> getUserByMail(String mail) {
        BsAdminUserBO bo = bsAdminUserMapper.getByMail(mail);
        return bo == null ? ResponseDzz.build("0", "用户不存在") : ResponseDzz.ok(bo);
    }

    /**
     * 根据用户ID取用户信息
     *
     * @param userId 用户id
     * @return 用户信息
     */
    @Override
    public ResponseDzz<AdminUserDetailBO> selectByUserId(String userId) {
        AdminUserDetailBO adminUserDetailBO = bsAdminUserMapper.selectUserDetailByUserId(userId);
        return ResponseDzz.ok(adminUserDetailBO);
    }

    /**
     * 根据用户账号取用户信息
     *
     * @param account 用户账号
     * @return 用户信息
     */
    @Override
    public ResponseDzz<AdminUserDetailBO> selectByAccount(String account) {
        AdminUserDetailBO adminUserDetailBO = bsAdminUserMapper.selectUserDetailByAccount(account);
        return ResponseDzz.ok(adminUserDetailBO);
    }

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return 更新是否成功
     */
    @Override
    public ResponseDzz<Boolean> updateUser(BsUserUpdateDTO user) {
        BsAdminUser bsAdminUser = bsAdminUserMapper.selectByUserId(user.getUserId());
        if (bsAdminUser == null) {
            return ResponseDzz.build("0", "用户不存在, 更新失败");
        }
        BeanUtils.copyProperties(user, bsAdminUser);

        Integer updateCount = bsAdminUserMapper.updateByPrimaryKeySelective(bsAdminUser);
        if (updateCount > 0) {
            return ResponseDzz.ok(Boolean.TRUE);
        } else {
            return ResponseDzz.ok(Boolean.FALSE);
        }
    }

    /**
     * 更新用户状态
     *
     * @param userId   用户Id
     * @param status   状态信息
     * @param userCode 更新人
     * @return 更新成功与否
     */
    @Override
    public ResponseDzz<Boolean> updateUserStatus(String status, String userId, String userCode) {
        Integer updateCount = bsAdminUserMapper.updateStatus(Integer.valueOf(status), userId, userCode);
        if (updateCount > 0) {
            return ResponseDzz.ok(Boolean.TRUE);
        } else {
            return ResponseDzz.ok(Boolean.FALSE);
        }

    }

    /**
     * 验证用户是否存在
     *
     * @param userId 用户Id
     * @return 用户是否存在, true存在,false不存在
     */
    @Override
    public ResponseDzz<Boolean> isExist(String userId) {
        BsAdminUser bsAdminUser = bsAdminUserMapper.selectByUserId(userId);
        if (bsAdminUser == null) {
            ResponseDzz.ok(Boolean.FALSE);
        }
        return ResponseDzz.ok(Boolean.TRUE);
    }

    /**
     * 修改密码
     *
     * @param userId   用户Id
     * @param password 密码
     * @return 更新成功与否 true修改成功, false, 修改不成功
     */
    @Override
    public ResponseDzz<Boolean> updatePassword(String userId, String password) {
        BsAdminUser bsAdminUser = bsAdminUserMapper.selectByUserId(userId);
        bsAdminUser.setPassword(Md5Crypt.md5Crypt(password.getBytes(), UserAccountUtil.getSaltValue(bsAdminUser.getAccount())));
        Integer countUpdate = bsAdminUserMapper.updateByPrimaryKeySelective(bsAdminUser);
        if (countUpdate > 0) {
            return ResponseDzz.ok(Boolean.TRUE);
        } else {
            return ResponseDzz.ok(Boolean.FALSE);
        }
    }

    /**
     * 验证用户密码是否正确
     *
     * @param password    密码
     * @param userAccount 用户账户
     * @param oldPassword 用户原密码
     * @return 正确data返回true, 错误返回false
     */
    @Override
    public ResponseDzz<Boolean> checkPassword(String password, String userAccount, String oldPassword) {

        Boolean flag = oldPassword.equals(Md5Crypt.md5Crypt(password.getBytes(),UserAccountUtil.getSaltValue(userAccount)));
        return ResponseDzz.ok(flag);

    }


    /**
     * 根据部门id, 查询本部门所有人员
     * @param departmentId 部门id
     * @return 人员信息
     */
    @Override
    public ResponseDzz<List<BsAdminUserBO>> selectUserByDepartmentId(String departmentId) {
        List<BsAdminUserBO> adminUserBOList= bsAdminUserMapper.selectUserByDepartmentId(departmentId);
        return ResponseDzz.ok(adminUserBOList);
    }

}
