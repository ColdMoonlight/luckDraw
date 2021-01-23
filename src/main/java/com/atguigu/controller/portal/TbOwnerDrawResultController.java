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
import com.atguigu.bean.TbOwnerLuckDraw;
import com.atguigu.common.Msg;
import com.atguigu.service.TbOwnerDrawResultService;
import com.atguigu.service.TbOwnerLuckDrawService;

@Controller
@RequestMapping("/TbOwnerLuckDraw")
public class TbOwnerDrawResultController {
	
	@Autowired
	TbOwnerLuckDrawService tbOwnerLuckDrawService;
	
	@Autowired
	TbOwnerDrawResultService tbOwnerDrawResultService;
	
	/**1.0	zsh 210120
	 * getOneLuckPeopleDetails
	 */
	@RequestMapping(value="/getAllPeopleName",method=RequestMethod.GET)
	@ResponseBody
	public Msg getAllPeopleName(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
		TbOwnerLuckDraw TbOwnerLuckDrawReq = new TbOwnerLuckDraw();
		TbOwnerLuckDrawReq.setLuckdrawStatus(0);
		
		//查询长度,去工具类里面,把长度值送进去,生成范围内的随机数,拿回来,取出该条对应的数据..
		List<TbOwnerLuckDraw> TbOwnerLuckDrawResList = new ArrayList<TbOwnerLuckDraw>();
		TbOwnerLuckDrawResList = tbOwnerLuckDrawService.selectTbOwnerLuckDrawAll();
		
		return Msg.success().add("resMsg", "获取人名成功").add("allPeopleList", TbOwnerLuckDrawResList);
	}
	
	@RequestMapping(value="/getAllZero",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAllZero(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
		tbOwnerLuckDrawService.updateAllToStatuszero();
		
		return Msg.success().add("resMsg", "重置完成");
	}

}
