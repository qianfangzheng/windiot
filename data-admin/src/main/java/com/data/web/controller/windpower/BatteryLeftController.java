package com.data.web.controller.windpower;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.biz.dto.BatteryLeftDTO;
import com.data.biz.service.IBizFanDatatotalDayService;
import com.data.biz.service.IBizFanDatatotalMonthService;
import com.data.biz.service.IBizFanDatatotalYearService;
import com.data.biz.service.IBizPowerPlantService;
import com.data.biz.service.IBizPowerStatisticsService;

/**
 *   电量统计
 * @author xzp
 *
 */
@Controller
@RequestMapping("/windpower/batteryleft")
public class BatteryLeftController {
	private String prefix = "windpower/batteryleft";  

	
	@Autowired
	private IBizPowerStatisticsService powerStatisticsService;
	@Autowired
	private IBizPowerPlantService powerPlantService;
	@Autowired
	private IBizFanDatatotalYearService iBizFanDatatotalYearService;
	
	@Autowired
	private IBizFanDatatotalMonthService iBizFanDatatotalMonthService;
	
	@Autowired
	private IBizFanDatatotalDayService iBizFanDatatotalDayService;
	
	@RequiresPermissions("windpower:batteryleft:view")
	@GetMapping()
	public String batteryleft(ModelMap map)
	{
		map.put("dayData", powerStatisticsService.getPower());
		map.put("monthData", powerStatisticsService.getMonthPower());
		map.put("yearData", powerStatisticsService.getYearPower());
		Long id = new Long(1);
		map.put("plantDataTotal", powerPlantService.getPlantDataById(id));
		return prefix + "/batteryleft";
	}
	
	
	@ResponseBody
	@RequestMapping("/listBatteryleft")
	public Map<String, List<BatteryLeftDTO>> listBatteryleft(){
		Map<String, List<BatteryLeftDTO>> resultMap = new HashMap<String, List<BatteryLeftDTO>>();
		resultMap.put("dayData", iBizFanDatatotalDayService.listGeneratingCapacityDay(1));
		resultMap.put("monthData", iBizFanDatatotalMonthService.listGeneratingCapacityDay(1));
		resultMap.put("yearData", iBizFanDatatotalYearService.listGeneratingCapacityDay(1));
		return resultMap;
	}
}
