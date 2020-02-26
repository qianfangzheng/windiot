package com.data.web.controller.windpower;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 风速统计查询表格
 * 
 * @author xzp
 */
@Controller
@RequestMapping("/windpower/windspeedStatisticsselect")
public class WindSpeedStatisticsSelectController {

	private String prefix = "windpower/windspeedStatisticsselect";

	@RequiresPermissions("windpower:windspeedStatisticsselect:view")
	@GetMapping()
	public String windspeedstatistical()
	{
		return prefix + "/windspeedStatisticsselect";
	}
}
