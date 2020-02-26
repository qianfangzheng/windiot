package com.data.web.controller.windpower;

import java.text.ParseException;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.biz.domain.BizWindData;
import com.data.biz.mapper.BizWindDatatotalMapper;
import com.data.biz.service.IBizWindDataService;
import com.data.common.annotation.Log;
import com.data.common.core.controller.BaseController;
import com.data.common.core.domain.AjaxResult;
import com.data.common.enums.BusinessType;

/**
 * 风速统计Controller
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-19
 */
@Controller
@RequestMapping("/windpower/data")
public class BizWindDataController extends BaseController
{
    private String prefix = "windpower/windspeedstatistical";

    @Autowired
    private IBizWindDataService bizWindDataService;
    @Autowired
    private BizWindDatatotalMapper bizWindDatatotalMapper;
    @GetMapping()
    public String data(ModelMap mmap) throws ParseException
    {
    	
        
    	mmap.put("dayData", bizWindDataService.selectBizWindDataList().get("dayData"));
    	mmap.put("monthData", bizWindDataService.selectBizWindDataList().get("monthData"));
    	mmap.put("yearData", bizWindDataService.selectBizWindDataList().get("yearData"));
    	mmap.put("dayData1", bizWindDatatotalMapper.selectRecentlyDay());
    	mmap.put("monthData1", bizWindDatatotalMapper.selectRecentlyMonth());
    	mmap.put("yearData1", bizWindDatatotalMapper.selectRecentlyYear());
        return prefix + "/windspeedstatistical";
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
    @RequiresPermissions("system:data:add")
    @Log(title = "风速统计", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BizWindData bizWindData)
    {
        return toAjax(bizWindDataService.insertBizWindData(bizWindData));
    }

    /**
     * 修改风速统计
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BizWindData bizWindData = bizWindDataService.selectBizWindDataById(id);
        mmap.put("bizWindData", bizWindData);
        return prefix + "/edit";
    }

    /**
     * 修改保存风速统计
     */
    @RequiresPermissions("system:data:edit")
    @Log(title = "风速统计", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BizWindData bizWindData)
    {
        return toAjax(bizWindDataService.updateBizWindData(bizWindData));
    }

    /**
     * 删除风速统计
     */
    @RequiresPermissions("system:data:remove")
    @Log(title = "风速统计", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bizWindDataService.deleteBizWindDataByIds(ids));
    }
}
