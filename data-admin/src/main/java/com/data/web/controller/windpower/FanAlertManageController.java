package com.data.web.controller.windpower;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.biz.domain.BizFan;
import com.data.biz.domain.BizFanFailure;
import com.data.biz.service.IBizFanFailureService;
import com.data.biz.vo.FanAlertManageVo;
import com.data.common.core.controller.BaseController;
import com.data.common.core.domain.AjaxResult;
import com.data.common.core.page.TableDataInfo;
import com.data.common.utils.poi.ExcelUtil;
import com.google.common.collect.Lists;

/**
 * 风机警报处理
 * @author xzp
 *
 */
@Controller
@RequestMapping("/windpower/fanalertmanage")
public class FanAlertManageController extends BaseController{
	private String prefix = "windpower/fanalertmanage";  

	@Autowired
	private IBizFanFailureService iBizFanFailureService;
	
	
	@RequiresPermissions("windpower:failure:view")
	@GetMapping()
	public String fanalarmmanage()
	{
		return prefix + "/fanalertmanage";
	}
	
	
	@PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BizFanFailure bizFanFailure)
    {
        startPage();
        List<BizFanFailure> list = iBizFanFailureService.selectBizFanFailureList(bizFanFailure);
        List<FanAlertManageVo> alertManageVos = Lists.newArrayList();
        
        for (BizFanFailure bizFanFailure_item : list) {
        	alertManageVos.add(iBizFanFailureService.transitionFanAlertManageVo(bizFanFailure_item));
		}
        return getDataTable(alertManageVos);
    }
	
	/**
         * 导出故障列表
     */
    @RequiresPermissions("windpower:failure:export")
    @RequestMapping("/export")
    @ResponseBody
    public AjaxResult export(BizFanFailure bizFanFailure)
    {
        List<BizFanFailure> list = iBizFanFailureService.selectBizFanFailureList(bizFanFailure);
        ExcelUtil<BizFanFailure> util = new ExcelUtil<BizFanFailure>(BizFanFailure.class);
        return util.exportExcel(list, "failure");
    }
    
    @RequestMapping("/updateStatus")
    @ResponseBody
	public AjaxResult updateStatus(@Param("failure_Id")long failure_Id,@RequestParam("remark")String remark) {
		return iBizFanFailureService.updateStatus(failure_Id,remark);
	}
}
