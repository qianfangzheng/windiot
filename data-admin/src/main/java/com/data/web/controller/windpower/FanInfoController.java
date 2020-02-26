package com.data.web.controller.windpower;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.biz.domain.BizFan;
import com.data.biz.domain.BizFanMatrix;
import com.data.biz.service.IBizFanService;
import com.data.biz.service.IBizPowerPlantService;
import com.data.common.biz.util.DateTimeUtil;
import com.data.common.core.controller.BaseController;
import com.data.common.core.page.TableDataInfo;

import TrendDB.API;
@Controller
@RequestMapping("/windpower/faninfo")
public class FanInfoController extends BaseController {
	/**
	 * 风机详情
	 * 
	 * @author xzp
	 */
	private String prefix = "windpower/faninfo";  

	@Autowired
	private IBizFanService iBizFanService;
	
	@Autowired
	private IBizPowerPlantService powerPlantService;
	
	@Autowired
	private IBizFanService fanService;
	
	@GetMapping()
	public String faninfo(Integer fanId,ModelMap map)
	{
		Long id = new Long(1);
		BizFanMatrix bizFanMatrix = new BizFanMatrix();
		bizFanMatrix.setPlantId(new Long(1));
		// 根据风机序号查询出风机信息
		BizFan bizFan = iBizFanService.getFanById(fanId);
		map.put("plantDataTotal", powerPlantService.getPlantDataById(id));
		// 转换日期格式
		bizFan.setInstallTime(DateTimeUtil.strToDate(DateTimeUtil.DateTostr(bizFan.getInstallTime())));
		map.put("bizFan", bizFan);
		map.put("bizFanDetail", iBizFanService.getFanDetailStatisticsDTO(fanId));
		return prefix + "/faninfo";
	}
	
	@PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BizFanMatrix bizFanMatrix)
    {
		Long id = new Long(1);
		bizFanMatrix.setPlantId(new Long(1));
        startPage();
        List<BizFanMatrix> list = fanService.getFanMatrix(bizFanMatrix);
        return getDataTable(list);
    }

}

