package com.data.web.controller.windpower;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.biz.domain.BizFanDatatotal;
import com.data.biz.domain.BizFanFailure;
import com.data.biz.service.IBizFanDatatotalDayService;
import com.data.biz.service.IBizFanDatatotalMonthService;
import com.data.biz.service.IBizFanDatatotalYearService;
import com.data.common.core.controller.BaseController;
import com.data.common.core.domain.AjaxResult;
import com.data.common.core.page.TableDataInfo;
import com.data.common.utils.poi.ExcelUtil;

/**
 * 电量统计查询
 * @author xzp
 *
 */
@Controller
@RequestMapping("/windpower/batteryleftselect")
public class BatteryLeftSelectController extends BaseController{
	private String prefix = "windpower/batteryleftselect";
	
	@GetMapping()
	public String batteryleftselect()
	{
		return prefix + "/batteryleftselect";
	}
	
	@Autowired
	private IBizFanDatatotalDayService iBizFanDatatotalDayService;
	
	@Autowired
	private IBizFanDatatotalMonthService iBizFanDatatotalMonthService;
	
	@Autowired
	private IBizFanDatatotalYearService iBizFanDatatotalYearService;
	
	List<BizFanDatatotal> list = null;
	
	@PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BizFanFailure bizFanFailure,HttpServletRequest request)
    {
        startPage();
        String dataType = request.getParameter("dataType");
        if (isEmpty(dataType)) {
			if (dataType.equals("monthData")) {
				list = iBizFanDatatotalMonthService.selectBizFanDatatotalList(null);
			}else if (dataType.equals("yearData")) {
				list = iBizFanDatatotalYearService.selectBizFanDatatotalList(null);
			}else if (dataType.equals("dayData")) {
				list = iBizFanDatatotalYearService.selectBizFanDatatotalList(null);
			}
		}else {
			list = iBizFanDatatotalDayService.selectBizFanDatatotalList(null);
		}
        return getDataTable(list);
    }
	
	@RequiresPermissions("windpower:datatotal:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BizFanDatatotal BizFanDatatotal)
    {
        ExcelUtil<BizFanDatatotal> util = new ExcelUtil<BizFanDatatotal>(BizFanDatatotal.class);
        return util.exportExcel(list, "datatotal");
    }
}
