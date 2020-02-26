package com.data.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.common.annotation.Log;
import com.data.common.core.controller.BaseController;
import com.data.common.core.domain.AjaxResult;
import com.data.common.core.page.TableDataInfo;
import com.data.common.enums.BusinessType;
import com.data.common.utils.poi.ExcelUtil;
import com.data.system.domain.SysUsers;
import com.data.system.service.ISysUsersService;

/**
 * 增删改查测试Controller
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-02
 */
@Controller
@RequestMapping("/system/users")
public class SysUsersController extends BaseController
{
    private String prefix = "system/users";

    @Autowired
    private ISysUsersService sysUsersService;

    @RequiresPermissions("system:users:view")
    @GetMapping()
    public String users()
    {
        return prefix + "/users";
    }

    /**
     * 查询增删改查测试列表
     */
    @RequiresPermissions("system:users:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysUsers sysUsers)
    {
        startPage();
        List<SysUsers> list = sysUsersService.selectSysUsersList(sysUsers);
        return getDataTable(list);
    }

    /**
     * 导出增删改查测试列表
     */
    @RequiresPermissions("system:users:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysUsers sysUsers)
    {
        List<SysUsers> list = sysUsersService.selectSysUsersList(sysUsers);
        ExcelUtil<SysUsers> util = new ExcelUtil<SysUsers>(SysUsers.class);
        return util.exportExcel(list, "users");
    }

    /**
     * 新增增删改查测试
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存增删改查测试
     */
    @RequiresPermissions("system:users:add")
    @Log(title = "增删改查测试", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysUsers sysUsers)
    {
        return toAjax(sysUsersService.insertSysUsers(sysUsers));
    }

    /**
     * 修改增删改查测试
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysUsers sysUsers = sysUsersService.selectSysUsersById(id);
        mmap.put("sysUsers", sysUsers);
        return prefix + "/edit";
    }

    /**
     * 修改保存增删改查测试
     */
    @RequiresPermissions("system:users:edit")
    @Log(title = "增删改查测试", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysUsers sysUsers)
    {
        return toAjax(sysUsersService.updateSysUsers(sysUsers));
    }

    /**
     * 删除增删改查测试
     */
    @RequiresPermissions("system:users:remove")
    @Log(title = "增删改查测试", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysUsersService.deleteSysUsersByIds(ids));
    }
}
