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
 * 风电项目主页Controller
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-02
 */
@Controller
@RequestMapping("/system/windPowerIndex")
public class windPowerIndex extends BaseController
{
    private String prefix = "system/windPowerIndex";


    @RequiresPermissions("system:windPowerIndex:view")
    @GetMapping()
    public String users()
    {
        return prefix + "/windPowerIndex";
    }

   
}
