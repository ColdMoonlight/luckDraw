package com.atguigu.controller.portal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.atguigu.bean.TbOwnerDrawResult;
import com.atguigu.bean.TbOwnerLuckDraw;
import com.atguigu.bean.TbOwnerNew;
import com.atguigu.common.Msg;
import com.atguigu.service.TbOwnerDrawResultService;
import com.atguigu.service.TbOwnerLuckDrawService;
import com.atguigu.service.TbOwnerNewService;
import com.atguigu.utils.DateUtil;

@Controller
@RequestMapping("/TbOwnerLuckDraw")
public class TbOwnerLuckDrawController {
	
	@Autowired
	TbOwnerLuckDrawService tbOwnerLuckDrawService;
	
	@Autowired
	TbOwnerDrawResultService tbOwnerDrawResultService;
	
	@Autowired
	TbOwnerNewService tbOwnerNewService;
	
	/**1.0	zsh 210120
	 * getOneLuckPeopleDetails
	 */
	@RequestMapping(value="/getOneLuckPeopleDetails",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneLuckPeopleDetails(HttpServletResponse rep,HttpServletRequest res,HttpSession session,@RequestBody TbOwnerLuckDraw tbOwnerLuckDraw){
		
		Integer luckdrawGrade = tbOwnerLuckDraw.getLuckdrawGrade();
		
		System.out.println("luckdrawGrade:"+luckdrawGrade);
		String winPropleName ="";
		
		//先查询new表,如果长度>0去出一个,返回展示
		TbOwnerNew tbOwnerNewReq = new TbOwnerNew();
		tbOwnerNewReq.setNewGrade(luckdrawGrade);//等级,状态默认1
		List<TbOwnerNew> tbOwnerNewList = tbOwnerNewService.selectTbOwnerNewByGrade(tbOwnerNewReq);
		
		if(tbOwnerNewList.size()>0){
			
			TbOwnerNew tbOwnerNewOne =tbOwnerNewList.get(0);
			winPropleName = tbOwnerNewOne.getNewName();
			
			//把这一条数据重置掉
			Integer newIdhasUsed = tbOwnerNewOne.getNewId();
			TbOwnerNew tbOwnerNewhasUsed = new TbOwnerNew();
			tbOwnerNewhasUsed.setNewId(newIdhasUsed);
			//tbOwnerNewhasUsed.setNewGrade(0);
			tbOwnerNewhasUsed.setNewStatus(0);//改成已中奖状态,默认都是0未中奖状态
			tbOwnerNewService.updateByPrimaryKeySelective(tbOwnerNewhasUsed);
			
		}else{
			
			TbOwnerLuckDraw TbOwnerLuckDrawReq = new TbOwnerLuckDraw();
			TbOwnerLuckDrawReq.setLuckdrawStatus(0);//拿出0未中奖状态的全部人,去工具类中随机抽奖
			
			//查询长度,去工具类里面,把长度值送进去,生成范围内的随机数,拿回来,取出该条对应的数据..
			List<TbOwnerLuckDraw> TbOwnerLuckDrawResList = new ArrayList<TbOwnerLuckDraw>();
			TbOwnerLuckDrawResList = tbOwnerLuckDrawService.selectTbOwnerLuckDrawNowUnLuck(TbOwnerLuckDrawReq);
			Integer nowpeopleNumber = TbOwnerLuckDrawResList.size();
			System.out.println("当前有"+nowpeopleNumber+"人可参与抽奖.");
			
			Integer luckNumber = beginGetLuck(nowpeopleNumber);
			
			TbOwnerLuckDraw tbOwnerLuckDrawOne = new TbOwnerLuckDraw();
			tbOwnerLuckDrawOne = TbOwnerLuckDrawResList.get(luckNumber);
			winPropleName = tbOwnerLuckDrawOne.getLuckdrawName();
			
			System.out.println("中奖人是:"+winPropleName); 
			
		}
		//用人名更;封装参数,更新本条对应人为已中奖状态,不再参与下次抽奖
		TbOwnerLuckDraw tbOwnerLuckDrawUpdate = new TbOwnerLuckDraw();
		tbOwnerLuckDrawUpdate.setLuckdrawName(winPropleName);
		tbOwnerLuckDrawUpdate.setLuckdrawStatus(1);//把这个人改成已中奖状态
		tbOwnerLuckDrawService.updateToLuckSuccess(tbOwnerLuckDrawUpdate);
		
		//把这个人的信息插入抽奖结果表中
		String nowTime = DateUtil.strTime14s();
		TbOwnerDrawResult tbOwnerDrawResultReq = new TbOwnerDrawResult();
		tbOwnerDrawResultReq.setDrawresultGrade(luckdrawGrade);
		tbOwnerDrawResultReq.setDrawresultName(winPropleName);
		tbOwnerDrawResultReq.setDrawresultCreatetime(nowTime);
		tbOwnerDrawResultReq.setDrawresultMotifytime(nowTime);
		tbOwnerDrawResultService.insertSelective(tbOwnerDrawResultReq);
		
		
		return Msg.success().add("resMsg", "抽奖成功").add("winPropleName", winPropleName);
	}
	
	private Integer beginGetLuck(Integer nowpeopleNumber) {
		
		Integer num = nowpeopleNumber;
		Random r = new Random();
		int i= r.nextInt(num);//生成[0,n)区间的整数
		Integer finalnumber = i;
		System.out.println("finalnumber:"+finalnumber);
		return finalnumber;
	}
	
	@RequestMapping(value="/getAllPeopleName",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAllPeopleName(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
		TbOwnerLuckDraw TbOwnerLuckDrawReq = new TbOwnerLuckDraw();
		TbOwnerLuckDrawReq.setLuckdrawStatus(0);
		
		//查询长度,去工具类里面,把长度值送进去,生成范围内的随机数,拿回来,取出该条对应的数据..
		List<TbOwnerLuckDraw> TbOwnerLuckDrawResList = new ArrayList<TbOwnerLuckDraw>();
		TbOwnerLuckDrawResList = tbOwnerLuckDrawService.selectTbOwnerLuckDrawAllByStatus(TbOwnerLuckDrawReq);
		
		return Msg.success().add("resMsg", "获取人名成功").add("allPeopleList", TbOwnerLuckDrawResList);
	}
	
	@RequestMapping(value="/getAllZero",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAllZero(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		//改掉这些人为可抽奖状态,
		tbOwnerLuckDrawService.updateAllToStatuszero();
		//删掉抽奖结果
		tbOwnerDrawResultService.deleteAll();
		
		return Msg.success().add("resMsg", "重置完成");
	}

}
