package com.data.web.controller.windpower;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.biz.domain.BizWindDatatotal;
import com.data.biz.service.IBizWindDatatotalService;
import com.data.common.annotation.Log;
import com.data.common.core.controller.BaseController;
import com.data.common.core.domain.AjaxResult;
import com.data.common.core.page.TableDataInfo;
import com.data.common.enums.BusinessType;
import com.data.common.utils.poi.ExcelUtil;

/**
 * 风速统计Controller
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
@Controller
@RequestMapping("/system/datatotal")
public class BizWindDatatotalController extends BaseController
{
    private String prefix  = "windpower/datatotal";

    @Autowired
    private IBizWindDatatotalService bizWindDatatotalService;

    @RequiresPermissions("system:datatotal:view")
    @GetMapping()
    public String datatotal(ModelMap mmap)
    {
    	mmap.put("bizWindD", "12.22");
        return prefix + "/datatotal";
    }
    
    
    @RequiresPermissions("system:datatotal:view")
    @GetMapping("/wind")
    public String windDatatotal(ModelMap mmap)
    {
    	mmap.put("bizWindD", "12.22");
        return prefix + "/winddatatotal";
    }
    

    /**
     * 查询风速统计列表
     */
    @RequiresPermissions("system:datatotal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BizWindDatatotal bizWindDatatotal)
    {
        startPage();
        List<BizWindDatatotal> list = bizWindDatatotalService.selectBizWindDatatotalList(bizWindDatatotal);
        return getDataTable(list);
    }
    
    @GetMapping("/recentlyList")
    @ResponseBody
    public Map<String,Object> recentlyList()
    {
    	Map<String,Object> list = bizWindDatatotalService.recentlyList();
        return list;
    }

    /**
     * 导出风速统计列表
     */
    @RequiresPermissions("system:datatotal:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BizWindDatatotal bizWindDatatotal)
    {
        List<BizWindDatatotal> list = bizWindDatatotalService.selectBizWindDatatotalList(bizWindDatatotal);
        ExcelUtil<BizWindDatatotal> util = new ExcelUtil<BizWindDatatotal>(BizWindDatatotal.class);
        return util.exportExcel(list, "BizWindDatatotal");
    }

    /**
     * 新增风速统计
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存风速统计
     */
    @RequiresPermissions("system:datatotal:add")
    @Log(title = "风速统计", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BizWindDatatotal bizWindDatatotal)
    {
        return toAjax(bizWindDatatotalService.insertBizWindDatatotal(bizWindDatatotal));
    }

    /**
     * 修改风速统计
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BizWindDatatotal bizWindDatatotal = bizWindDatatotalService.selectBizWindDatatotalById(id);
        mmap.put("bizWindDatatotal", bizWindDatatotal);
        return prefix + "/edit";
    }

    /**
     * 修改保存风速统计
     */
    @RequiresPermissions("system:datatotal:edit")
    @Log(title = "风速统计", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BizWindDatatotal bizWindDatatotal)
    {
        return toAjax(bizWindDatatotalService.updateBizWindDatatotal(bizWindDatatotal));
    }

    /**
     * 删除风速统计
     */
    @RequiresPermissions("system:datatotal:remove")
    @Log(title = "风速统计", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bizWindDatatotalService.deleteBizWindDatatotalByIds(ids));
    }
}
