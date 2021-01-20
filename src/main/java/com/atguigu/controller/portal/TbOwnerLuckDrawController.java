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
import com.atguigu.service.TbOwnerLuckDrawService;

@Controller
@RequestMapping("/TbOwnerLuckDraw")
public class TbOwnerLuckDrawController {
	
	@Autowired
	TbOwnerLuckDrawService tbOwnerLuckDrawService;
	
	/**1.0	zsh 210120
	 * getOneLuckPeopleDetails
	 */
	@RequestMapping(value="/getOneLuckPeopleDetails",method=RequestMethod.POST)
	@ResponseBody
	public Msg getCartitemIdDetails(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
		TbOwnerLuckDraw TbOwnerLuckDrawReq = new TbOwnerLuckDraw();
		TbOwnerLuckDrawReq.setLuckdrawStatus(0);
		
		//查询长度,去工具类里面,把长度值送进去,生成范围内的随机数,拿回来,取出该条对应的数据..
		List<TbOwnerLuckDraw> TbOwnerLuckDrawResList = new ArrayList<TbOwnerLuckDraw>();
		TbOwnerLuckDrawResList = tbOwnerLuckDrawService.selectTbOwnerLuckDrawNowUnLuck(TbOwnerLuckDrawReq);
		
		Integer nowpeopleNumber = TbOwnerLuckDrawResList.size();
		
		Integer luckNumber = beginGetLuck(nowpeopleNumber);
		
		TbOwnerLuckDraw tbOwnerLuckDrawOne = new TbOwnerLuckDraw();
		tbOwnerLuckDrawOne = TbOwnerLuckDrawResList.get(luckNumber);
		
		System.out.println("这是个幸运的人:"+tbOwnerLuckDrawOne.toString());
		
		
		return Msg.success().add("resMsg", "抽奖成功").add("tbOwnerLuckDrawOne", tbOwnerLuckDrawOne);
	}
	
	private Integer beginGetLuck(Integer nowpeopleNumber) {
		
		Integer num = nowpeopleNumber;
		
		double d = (int)(Math.random()*num);//因为不需要0，所以需要加1
		
		Integer finalnumber = (int) d;
		
		System.out.println("finalnumber:"+finalnumber);
		return finalnumber;
	}

	
}
