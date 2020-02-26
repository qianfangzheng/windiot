package com.data.web.controller.windpower;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.biz.domain.BizFan;
import com.data.biz.service.IBizFanService;
import com.data.biz.service.IBizPowerPlantService;
import com.data.biz.service.IBizPowerStatisticsService;

/**
 * 全场地图
 * 
 * @author xzp
 */
@Controller
@RequestMapping("/windpower/fullmap")
public class FullMapController {

	private String prefix = "windpower/fullmap";
	@Autowired
	private IBizPowerPlantService powerPlantService;
	
	@Autowired
	private IBizPowerStatisticsService powerStatisticsService;
	
	@Autowired
	private IBizFanService iBizFanService;
	
	@GetMapping()
	public String batteryleft(ModelMap map)
	{
		map.put("dayData", powerStatisticsService.getPower());
		map.put("monthData", powerStatisticsService.getMonthPower());
		map.put("yearData", powerStatisticsService.getYearPower());
		Long id = new Long(1);
		map.put("plantDataTotal", powerPlantService.getPlantDataById(id));
		return prefix + "/fullmap";
	}
	
	@RequestMapping("/fanList")
	@ResponseBody
	public List<BizFan> FanList(){
		return iBizFanService.selectBizFanList(null);
	}
}
