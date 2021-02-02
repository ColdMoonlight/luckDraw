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
	
	
	/**1.0	unuse
	 * tbOwnerNewPage
	 */
	@RequestMapping("/tbOwnerNewPage")
	public String tbOwnerNewPage(HttpSession session) throws Exception{
		
		return "back/ownerNewPage";
	}

	/**2.0	unuse
	 * tbOwnerNewIntoEffect
	 */
	@RequestMapping(value="/tbOwnerNewIntoEffect",method=RequestMethod.POST)
	@ResponseBody
	public Msg tbOwnerNewIntoEffect(HttpServletResponse rep,HttpServletRequest res,HttpSession session,@RequestBody TbOwnerNew TbOwnerNewInto){
		
		Integer grade = TbOwnerNewInto.getNewGrade();
		
		TbOwnerNew TbOwnerNew = new TbOwnerNew();
		TbOwnerNew.setNewGrade(grade);
		TbOwnerNew.setNewStatus(1);
		
		tbOwnerNewService.updateTwoIntoEffect(TbOwnerNew);
		
		return Msg.success().add("resMsg", "重置完成");
	}

}
