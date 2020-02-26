package com.data.web.controller.windpower;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 风向统计查询
 * 
 * @author xzp
 */
@Controller
@RequestMapping("/windpower/winddstatisticsselect")
public class WindDStatisticsSelectController {

	private String prefix = "windpower/winddstatisticsselect";

	@RequiresPermissions("windpower:winddstatisticsselect:view")
	@GetMapping()
	public String windspeedstatistical()
	{
		return prefix + "/winddstatisticsselect";
	}
}