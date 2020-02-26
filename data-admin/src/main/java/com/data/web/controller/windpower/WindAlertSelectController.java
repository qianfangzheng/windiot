package com.data.web.controller.windpower;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.biz.domain.BizFanDatatotal;
import com.data.biz.domain.BizFanFailure;
import com.data.biz.service.IBizFanFailureService;
import com.data.biz.service.impl.BizFanFailureServiceImpl;
import com.data.biz.vo.FanyawSelectVo;
import com.data.biz.vo.WindAlertSelectVo;
import com.data.common.core.controller.BaseController;
import com.data.common.core.page.TableDataInfo;
import com.google.common.collect.Lists;

/**
 * 风机警报统计
 * @author xzp
 *
 */
@Controller
@RequestMapping("/windpower/windalertselect")
public class WindAlertSelectController extends BaseController{
	private String prefix = "windpower/windalertselect";  

	@Autowired
	private IBizFanFailureService bizFanFailureService;
	
	@GetMapping()
	public String windalertselect()
	{
		return prefix + "/windalertselect";
	}
	
	@PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BizFanDatatotal bizFanDatatotal,HttpServletRequest request)
    {
        startPage();
        List<WindAlertSelectVo> list = bizFanFailureService.faultStatistics();
        return getDataTable(list);
    }
}
