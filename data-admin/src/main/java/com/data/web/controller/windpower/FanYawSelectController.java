package com.data.web.controller.windpower;

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
import com.data.biz.service.IBizFanDatatotalDayService;
import com.data.biz.service.IBizFanDatatotalMonthService;
import com.data.biz.service.IBizFanDatatotalYearService;
import com.data.biz.service.IBizFanFailureService;
import com.data.biz.vo.FanAlertManageVo;
import com.data.biz.vo.FanyawSelectVo;
import com.data.common.core.controller.BaseController;
import com.data.common.core.page.TableDataInfo;
import com.google.common.collect.Lists;

/**
 *   风机偏航统计查询
 * @author xzp
 *
 */
@Controller
@RequestMapping("/windpower/fanyawSelect")
public class FanYawSelectController extends BaseController{
	private String prefix = "windpower/fanyawSelect";  

	@Autowired
	private IBizFanDatatotalDayService iBizFanDatatotalDayService;

	@Autowired
	private IBizFanDatatotalMonthService iBizFanDatatotalMonthService;
	
	@Autowired
	private IBizFanDatatotalYearService iBizFanDatatotalYearService;
	
	@GetMapping()
	public String fanmatrix()
	{
		return prefix + "/fanyawSelect";
	}

	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BizFanDatatotal bizFanDatatotal,HttpServletRequest request)
	{
		String dataType = request.getParameter("dataType");
		startPage();
		List<FanyawSelectVo> list = Lists.newArrayList();
		List<BizFanDatatotal> lBizFanDatatotals = null;
		if (isEmpty(dataType)) {
			if (dataType.equals("dayData")) {
				lBizFanDatatotals = iBizFanDatatotalDayService.selectBizFanDatatotalList(null);
			}else if (dataType.equals("monthData")) {
				lBizFanDatatotals = iBizFanDatatotalMonthService.selectBizFanDatatotalList(null);
			}else if (dataType.equals("yearData")) {
				lBizFanDatatotals = iBizFanDatatotalYearService.selectBizFanDatatotalList(null);
			}
		}else {
			lBizFanDatatotals = iBizFanDatatotalDayService.selectBizFanDatatotalList(null);
		}
		for (BizFanDatatotal item : lBizFanDatatotals) {
			list.add(iBizFanDatatotalDayService.transformFanyawSelectVo(item));
		}
		return getDataTable(lBizFanDatatotals);
	}
}
