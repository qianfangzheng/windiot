package com.data.web.controller.windpower;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.data.biz.domain.BizFanFailure;
import com.data.biz.dto.BatteryLeftDTO;
import com.data.biz.mapper.BizFanDatatotalDayMapper;
import com.data.biz.mapper.BizFanDatatotalMonthMapper;
import com.data.biz.mapper.BizFanDatatotalYearMapper;
import com.data.biz.vo.FanAlertManageVo;
import com.data.common.core.controller.BaseController;
import com.data.common.core.page.TableDataInfo;
import com.google.common.collect.Lists;

/**
 * 电量详情
 * @author xzp
 *
 */
@Controller
@RequestMapping("/windpower/electricdetailed")
public class ElectricDetailedController extends BaseController{
	private String prefix = "windpower/electricdetailed";  
	
	@Autowired
	private BizFanDatatotalDayMapper bizFanDatatotalDayMapper;

	@Autowired
	private BizFanDatatotalMonthMapper bizFanDatatotalMonthMapper;

	@Autowired
	private BizFanDatatotalYearMapper bizFanDatatotalYearMapper;
	
	@GetMapping()
	public String fanlist()
	{
		return prefix + "/electricdetailed";
	}

	@RequestMapping("/electricdetailedFlag")
	public String electricdetailedFlag(String name,HttpServletRequest request) {
		request.setAttribute("dataToken", request.getParameter("dataToken"));
		return prefix + "/electricdetailed";
	}

	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BizFanFailure bizFanFailure)
	{
		HttpServletRequest request = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest();
		String dataToken = request.getParameter("dataToken").toString();
		startPage();
		List<BatteryLeftDTO> leftDTOs = bizFanDatatotalDayMapper.selectBatteryLeftBTONotLimit(1);
		if (isEmpty(dataToken)) {
			if (dataToken.equals("yearData")) {
				leftDTOs = bizFanDatatotalYearMapper.selectBatteryLeftBTONotLimit(1);
			}else if (dataToken.equals("monthData")) {
				leftDTOs = bizFanDatatotalMonthMapper.selectBatteryLeftBTONotLimit(1);
			}
		}
		return getDataTable(leftDTOs);
	}

}
