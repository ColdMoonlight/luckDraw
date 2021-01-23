package com.atguigu.controller.portal;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.atguigu.bean.TbOwnerDrawResult;
import com.atguigu.common.Msg;
import com.atguigu.service.TbOwnerDrawResultService;

@Controller
@RequestMapping("/TbOwnerLuckDraw")
public class TbOwnerDrawResultController {
	
	@Autowired
	TbOwnerDrawResultService tbOwnerDrawResultService;
	
	/**1.0	zsh 210120
	 * getOneLuckPeopleDetails
	 */
	@RequestMapping(value="/getAllresult",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAllPeopleName(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
		//查询长度,去工具类里面,把长度值送进去,生成范围内的随机数,拿回来,取出该条对应的数据..
		List<TbOwnerDrawResult> TbOwnerDrawResultResList = new ArrayList<TbOwnerDrawResult>();
		TbOwnerDrawResultResList = tbOwnerDrawResultService.selectTbOwnerDrawResultAll();
		
		return Msg.success().add("resMsg", "获取人名成功").add("allWinPeopleList", TbOwnerDrawResultResList);
	}
	
	@RequestMapping(value="/getAllDrawResultToGradezero",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAllDrawResultToGradezero(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
		tbOwnerDrawResultService.updateAllDrawResultToGradezero();
		
		return Msg.success().add("resMsg", "重置完成");
	}

}
