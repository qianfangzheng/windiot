package com.data.web.controller.windpower;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.biz.domain.BizCabin;
import com.data.biz.domain.BizFan;
import com.data.biz.domain.BizFanFailure;
import com.data.biz.domain.BizFanSpeed;
import com.data.biz.service.IBizCabinService;
import com.data.biz.service.IBizFanService;
import com.data.biz.service.IBizFanSpeedService;
import com.data.biz.service.IBizPowerPlantService;
import com.data.biz.service.IBizPowerStatisticsService;
import com.data.biz.vo.FanAlertManageVo;
import com.data.biz.vo.FanListVo;
import com.data.common.biz.util.PropertiesUtil;
import com.data.common.biz.util.TrendDBUtil;
import com.data.common.core.controller.BaseController;
import com.data.common.core.domain.AjaxResult;
import com.data.common.core.page.TableDataInfo;
import com.google.common.collect.Lists;

import TrendDB.API;
import TrendDB.DB_Exception;
import TrendDB.TagConfig;

@Controller
@RequestMapping("/windpower/fanlist")
public class FanListController extends BaseController{
	/**
	 * 风机列表
	 * 
	 * @author xzp
	 */
	private String prefix = "windpower/fanlist";  

	@Autowired
	private IBizFanService iBizFanService;

	@Autowired
	private IBizFanSpeedService iBizFanSpeedService;

	@Autowired
	private IBizCabinService iBizCabinService;

	@Autowired
	private IBizPowerPlantService powerPlantService;

	@Autowired
	private IBizPowerStatisticsService powerStatisticsService;

	@Autowired
	private IBizFanService bizFanService;

	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BizFan bizFan)
	{
		startPage();
		List<FanListVo> listVos = iBizFanService.listFanListVos(1);
		return getDataTable(listVos);
	}

	/**
	 * 新增【请填写功能名称】
	 */
	@GetMapping("/add")
	public String add()
	{
		return prefix + "/add";
	}

	/**
	 * 新增保存【请填写功能名称】
	 */
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BizFan bizFan)
	{
		insertTag(bizFan.getFanCode());
		return toAjax(bizFanService.insertBizFan(bizFan));
	}

	@GetMapping()
	public String batteryleft(ModelMap map)
	{
		map.put("dayData", powerStatisticsService.getPower());
		map.put("monthData", powerStatisticsService.getMonthPower());
		map.put("yearData", powerStatisticsService.getYearPower());
		Long id = new Long(1);
		map.put("plantDataTotal", powerPlantService.getPlantDataById(id));
		return prefix + "/fanlist";
	}
	
	public static void insertTag(String name) {
		String connId = PropertiesUtil.getValue("connId");
		TrendDBUtil.createConnection();
		  try {
		   String[] sys_vars = { "cabinT", "cabinAngle", "oilT", "lowt", "hight", "oilPressure", "acVoltage",
		     "fanOutput", "fanOutputFrequency", "fanFactor", "instantaneousPower", "rotateSpeed" };
		   TagConfig[] configList = new TagConfig[sys_vars.length];
		   for (int i = 0; i < sys_vars.length; ++i) {
		    TagConfig config = new TagConfig();
		    String tmp = "fan." + sys_vars[i] + ".";
		    config.type = TagConfig.TAG_CONTINUOUS;
		    config.comDev = 0.01f;
		    config.histDepth = 300;
		    config.histDays = 36500;
		    config.precision = 23;
		    config.archive = true;
		    config.statistics = true;
		    config.otherWR = true;
		    config.otherRD = true;
		    config.grpRD = true;
		    config.grpWR = true;
		    config.mirror = false;
		    config.name = tmp + name;
		    config.addr = tmp + name;
		    config.desc = tmp + name;
		    config.unit = "kwh";
//		     config.name = String.format("3.%02d", i);
//		     config.addr = String.format("3.%02d", i);
//		     config.desc = String.format("3.%02d", i);
		    configList[i] = config;
		   }
		   for (TagConfig config : configList) {
		    System.out.println(config.toString());
		   }
		   int[] retV = API.AddTagList(connId, configList);
		   for (int j = 0; j < retV.length; ++j) {
		    System.out.println(j + ", ret code: " + retV[j]);
		   }

		  } catch (DB_Exception ex) {
		   System.out.println(ex.GetErrMsg() + ", error: " + ex.errno);
		  }
		  TrendDBUtil.closeConnection();
		 }
}
