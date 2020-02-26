package com.data.web.controller.windpower;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.data.biz.service.IBizFunctionalTestService;
import com.data.common.biz.domain.DBParam;
import com.data.common.biz.domain.DBResult;
import com.data.common.core.controller.BaseController;
@Controller
@RequestMapping("/windpower/functionaltest")
public class FunctionalTestController extends BaseController {
	/**
	 * 性能测试
	 * 
	 * @author xzp
	 */
	private String prefix = "windpower/functionaltest";  

	@Autowired
	private IBizFunctionalTestService functionalTestService;

	
	@GetMapping()
	public String faninfo(Integer fanId,ModelMap mmap)
	{
//		Long id = new Long(1);
//		System.out.println(fanId);
//		BizFanMatrix bizFanMatrix = new BizFanMatrix();
//		bizFanMatrix.setPlantId(new Long(1));
		String[] names = functionalTestService.getAllTags();
		mmap.put("names", names);
		return prefix + "/functionaltest";
	}
	
	@RequestMapping("/singleTagsData")
	@ResponseBody
	public Map<String,Object> InsertSingleTagsData(DBParam param) {
//		AjaxResult result = new AjaxResult();
		Map<String,Object> map = new HashMap<String,Object>();
		DBResult r = new DBResult();
		try {
			r=functionalTestService.insertMoreData(param);
			map.put("result", r);
			//成功
			map.put("code", 1);
		} catch (Exception e) {
			//异常
			e.printStackTrace();
			map.put("code", 2);
		}
		
		return map;
	}
	@RequestMapping("/multipleTagsData")
	@ResponseBody
	public Map<String,Object> InsertMultipleTagsData(DBParam param) {
//		AjaxResult result = new AjaxResult();
		Map<String,Object> map = new HashMap<String,Object>();
		DBResult r = new DBResult();
		try {
			r=functionalTestService.insertDataMore(param);
			map.put("result", r);
			//成功
			map.put("code", 1);
		} catch (Exception e) {
			//异常
			e.printStackTrace();
			map.put("code", 2);
		}
		
		return map;
	}
	

}

