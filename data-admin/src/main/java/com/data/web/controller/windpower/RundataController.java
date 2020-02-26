package com.data.web.controller.windpower;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.biz.dto.BatteryLeftDTO;
import com.data.biz.dto.RunDataDTO;
import com.data.biz.service.IBizFanDatatotalDayService;
import com.data.biz.service.IBizFanDatatotalMonthService;
import com.data.biz.service.IBizFanDatatotalYearService;
import com.data.biz.service.IBizRunDataService;

/**
 * 运行数据
 * 
 * @author xzp
 */
@Controller
@RequestMapping("/windpower/rundata")
public class RundataController {

	private String prefix = "windpower/rundata";
	
	@Autowired
	private IBizRunDataService IBizRunDataService;

	
	@GetMapping()
    public String index(HttpServletRequest request)
    {
		request.getSession().setAttribute("runDataVo", IBizRunDataService.selectRunDataVo(1));
        return prefix + "/index";
    }
	
}
