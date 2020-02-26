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

import com.data.biz.domain.BizFanMatrix;
import com.data.biz.service.IBizFanService;
import com.data.biz.service.IBizPowerPlantService;
import com.data.common.core.controller.BaseController;
import com.data.common.core.page.PageDomain;
import com.data.common.core.page.TableDataInfo;
import com.data.common.core.page.TableSupport;
import com.data.common.utils.StringUtils;
import com.data.common.utils.sql.SqlUtil;
import com.data.system.domain.SysDictData;
import com.github.pagehelper.PageHelper;
@Controller
@RequestMapping("/windpower/fanmatrix")
public class FanMatrixController extends BaseController {
	/**
	 * 风机矩阵
	 * 
	 * @author xzp
	 */
	private String prefix = "windpower/fanmatrix";  

	@Autowired
	private IBizPowerPlantService powerPlantService;
	@Autowired
	private IBizFanService fanService;
	
	@GetMapping()
	public String fanmatrix(ModelMap mmap)
	{
		Long id = new Long(1);
		BizFanMatrix bizFanMatrix = new BizFanMatrix();
		bizFanMatrix.setPlantId(new Long(1));
    	mmap.put("plantDataTotal", powerPlantService.getPlantDataById(id));
    	mmap.put("fanList",fanService.getFanMatrix(bizFanMatrix));
		return prefix + "/fanmatrix";
	}
	
	@PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BizFanMatrix bizFanMatrix)
    {
		Long id = new Long(1);
		bizFanMatrix.setPlantId(new Long(1));
        startPage();
        List<BizFanMatrix> list = fanService.getFanMatrix(bizFanMatrix);
        return getDataTable(list);
    }

}

