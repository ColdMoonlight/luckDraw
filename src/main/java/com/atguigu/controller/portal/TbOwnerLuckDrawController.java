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
	@RequestMapping(value="/getOneLuckPeopleDetails",method=RequestMethod.GET)
	@ResponseBody
	public Msg getCartitemIdDetails(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
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
			
			Integer peopleId = tbOwnerLuckDrawOne.getLuckdrawId();
			
			//封装参数，更新本条对应人为已中奖状态，不再参与下次抽奖
			
			TbOwnerLuckDraw tbOwnerLuckDrawUpdate = new TbOwnerLuckDraw();
			tbOwnerLuckDrawUpdate.setLuckdrawId(peopleId);
			tbOwnerLuckDrawUpdate.setLuckdrawStatus(1);
			
			tbOwnerLuckDrawService.updateByPrimaryKeySelective(tbOwnerLuckDrawUpdate);
		
		return Msg.success().add("resMsg", "抽奖成功").add("tbOwnerLuckDrawOne", tbOwnerLuckDrawOne);
	}
	
	private Integer beginGetLuck(Integer nowpeopleNumber) {
		
		Integer num = nowpeopleNumber;
		
		double d = (int)(Math.random()*num);//因为不需要0,所以需要加1
		
		Integer finalnumber = (int) d;
		
		System.out.println("finalnumber:"+finalnumber);
		return finalnumber;
	}

}
