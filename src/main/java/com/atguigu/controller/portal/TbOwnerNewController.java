package com.atguigu.controller.portal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.atguigu.bean.TbOwnerNew;
import com.atguigu.common.Msg;
import com.atguigu.service.TbOwnerNewService;

@Controller
@RequestMapping("/TbOwnerNew")
public class TbOwnerNewController {
	
	@Autowired
	TbOwnerNewService tbOwnerNewService;
	
	/**1.0	use
	 * tbOwnerNewAllToOne
	 */
	@RequestMapping(value="/tbOwnerNewAllToOne",method=RequestMethod.POST)
	@ResponseBody
	public Msg tbOwnerNewAllToOne(HttpServletResponse rep,HttpServletRequest res,HttpSession session,@RequestBody TbOwnerNew TbOwnerNew){
		
		TbOwnerNew tbOwnerNewReq =new TbOwnerNew();
		for(int i=1;i<=4;i++){
			tbOwnerNewReq.setNewId(i);
			tbOwnerNewReq.setNewGrade(1);
		}
		tbOwnerNewService.updateByPrimaryKeySelective(tbOwnerNewReq);
		
		return Msg.success().add("resMsg", "抽奖成功").add("tbOwnerLuckDrawOne", null);
	}
	
	/**2.0	unuse
	 * tbOwnerNewAllToZero
	 */
	@RequestMapping(value="/tbOwnerNewAllToZero",method=RequestMethod.POST)
	@ResponseBody
	public Msg tbOwnerNewAllToZero(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
		tbOwnerNewService.setAllToZero();
		
		return Msg.success().add("resMsg", "重置完成");
	}

}
