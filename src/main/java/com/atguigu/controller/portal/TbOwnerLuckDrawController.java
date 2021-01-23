package com.atguigu.controller.portal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.atguigu.bean.TbOwnerDrawResult;
import com.atguigu.bean.TbOwnerLuckDraw;
import com.atguigu.common.Msg;
import com.atguigu.service.TbOwnerDrawResultService;
import com.atguigu.service.TbOwnerLuckDrawService;

@Controller
@RequestMapping("/TbOwnerLuckDraw")
public class TbOwnerLuckDrawController {
	
	@Autowired
	TbOwnerLuckDrawService tbOwnerLuckDrawService;
	
	@Autowired
	TbOwnerDrawResultService tbOwnerDrawResultService;
	
	/**1.0	zsh 210120
	 * getOneLuckPeopleDetails
	 */
	@RequestMapping(value="/getOneLuckPeopleDetails",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneLuckPeopleDetails(HttpServletResponse rep,HttpServletRequest res,HttpSession session,TbOwnerLuckDraw tbOwnerLuckDraw){
		
		Integer luckdrawGrade = tbOwnerLuckDraw.getLuckdrawGrade();
		
		TbOwnerLuckDraw TbOwnerLuckDrawReq = new TbOwnerLuckDraw();
		TbOwnerLuckDrawReq.setLuckdrawStatus(0);
		
		//查询长度,去工具类里面,把长度值送进去,生成范围内的随机数,拿回来,取出该条对应的数据..
		List<TbOwnerLuckDraw> TbOwnerLuckDrawResList = new ArrayList<TbOwnerLuckDraw>();
		TbOwnerLuckDrawResList = tbOwnerLuckDrawService.selectTbOwnerLuckDrawNowUnLuck(TbOwnerLuckDrawReq);
			
		Integer nowpeopleNumber = TbOwnerLuckDrawResList.size();
		
		System.out.println("当前有"+nowpeopleNumber+"人可参与抽奖.");
		
		Integer luckNumber = beginGetLuck(nowpeopleNumber);
		
		TbOwnerLuckDraw tbOwnerLuckDrawOne = new TbOwnerLuckDraw();
		tbOwnerLuckDrawOne = TbOwnerLuckDrawResList.get(luckNumber);
		
		System.out.println("中奖人是:"+tbOwnerLuckDrawOne.getLuckdrawName());
		
		String winPropleName = tbOwnerLuckDrawOne.getLuckdrawName();
		
		Integer peopleId = tbOwnerLuckDrawOne.getLuckdrawId();
		
		//封装参数,更新本条对应人为已中奖状态,不再参与下次抽奖
		
		TbOwnerLuckDraw tbOwnerLuckDrawUpdate = new TbOwnerLuckDraw();
		tbOwnerLuckDrawUpdate.setLuckdrawId(peopleId);
		tbOwnerLuckDrawUpdate.setLuckdrawStatus(1);
		
		tbOwnerLuckDrawService.updateByPrimaryKeySelective(tbOwnerLuckDrawUpdate);
		
		TbOwnerDrawResult tbOwnerDrawResultReq = new TbOwnerDrawResult();
		tbOwnerDrawResultReq.setDrawresultGrade(luckdrawGrade);
		tbOwnerDrawResultReq.setDrawresultName(winPropleName);
		tbOwnerDrawResultService.insertSelective(tbOwnerDrawResultReq);
		
		return Msg.success().add("resMsg", "抽奖成功").add("tbOwnerLuckDrawOne", tbOwnerLuckDrawOne);
	}
	
	private Integer beginGetLuck(Integer nowpeopleNumber) {
		
		Integer num = nowpeopleNumber;
		Random r = new Random();
		int i= r.nextInt(num);//生成[0,n)区间的整数
		Integer finalnumber = i;
		System.out.println("finalnumber:"+finalnumber);
		return finalnumber;
	}
	
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
