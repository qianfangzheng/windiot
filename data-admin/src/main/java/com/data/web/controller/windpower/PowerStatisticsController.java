package com.data.web.controller.windpower;

import java.lang.annotation.Repeatable;
import java.util.Date;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.biz.dto.PowerDataDTO;
import com.data.biz.service.IBizPowerDataService;
import com.data.biz.service.IBizPowerPlantService;
import com.data.biz.service.IBizPowerStatisticsService;



/**
 *  功率统计
 * 
 * @author xzp
 */
@Controller
@RequestMapping("/windpower/powerstatistics")
public class PowerStatisticsController {
	private String prefix = "windpower/powerstatistics";
	@Autowired
	private IBizPowerStatisticsService powerStatisticsService;
	@Autowired
	private IBizPowerPlantService powerPlantService;
	@Autowired
	private IBizPowerDataService iBizPowerDataService;

	@RequiresPermissions("windpower:powerstatistics:view")
	@GetMapping()
	public String powerstatistics(ModelMap map)
	{
		map.put("dayData", powerStatisticsService.getPower());
		map.put("monthData", powerStatisticsService.getMonthPower());
		map.put("yearData", powerStatisticsService.getYearPower());
		Long id = new Long(1);
		map.put("plantDataTotal", powerPlantService.getPlantDataById(id));
		return prefix + "/powerstatistics";
	}

	@RequestMapping("/recentlyDate")
	@ResponseBody
	public List<Date> recentlyDate(int datatype){
		if (datatype == 1) {
			return iBizPowerDataService.recentlyDayDate(1,7);// 查询日记录,查询条数为7
		}else if (datatype == 2) {
			return iBizPowerDataService.recentlyDayDate(2,12);// 查询月记录,查询条数为12
		}else if (datatype == 3) {
			return iBizPowerDataService.recentlyDayDate(3,5);// 查询年记录,查询条数为5
		}
		return iBizPowerDataService.recentlyDayDate(1,7);// 查询日记录,查询条数为7
	}

	@RequestMapping("/listPowerDataDay")
	@ResponseBody
	public List<PowerDataDTO> listPowerDataDay(){
		return iBizPowerDataService.listPowerDataDTODay();
	}
	
	@RequestMapping("/listPowerDataMonth")
	@ResponseBody
	public List<PowerDataDTO> listPowerDataMonth() {
		return iBizPowerDataService.listPowerDataDTOMonth();
	}
	
	@RequestMapping("/listPowerDataYear")
	@ResponseBody
	public List<PowerDataDTO> listPowerDataYear() {
		return iBizPowerDataService.listPowerDataDTOYear();
	}
} 
