package com.data.web.controller.windpower;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.data.biz.mapper.BizWindDatatotalMapper;
import com.data.biz.service.IBizPowerPlantService;


/**
 * 风向统计
 * 
 * @author xzp
 */
@Controller
@RequestMapping("/windpower/thewindstatistics")
public class TheWindStatisticsController {

	private String prefix = "windpower/thewindstatistics";
	@Autowired
    private BizWindDatatotalMapper bizWindDatatotalMapper;
	@Autowired
	private IBizPowerPlantService powerPlantService;
	
	@RequiresPermissions("windpower:thewindstatistics:view")
	@GetMapping()
	public String windspeedstatistical(ModelMap mmap)
	{
		mmap.put("dayData", bizWindDatatotalMapper.selectRecentlyDay());
    	mmap.put("monthData", bizWindDatatotalMapper.selectRecentlyMonth());
    	mmap.put("yearData", bizWindDatatotalMapper.selectRecentlyYear());
    	Long id = new Long(1);
    	mmap.put("plantDataTotal", powerPlantService.getPlantDataById(id));
		return prefix + "/thewindstatistics";
	}
}