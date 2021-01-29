package com.atguigu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.TbOwnerDrawResult;
import com.atguigu.dao.TbOwnerDrawResultMapper;

@Service
public class TbOwnerDrawResultService {
	
	@Autowired
	TbOwnerDrawResultMapper tbOwnerDrawResultMapper;

	/**
	 * @author Shinelon
	 * @param TbOwnerDrawResult
	 * @exception add方法用户信息是否存在
	 * 	3.0
	 * */
	public int insertSelective(TbOwnerDrawResult TbOwnerDrawResult) {
		int intReslut = tbOwnerDrawResultMapper.insertSelective(TbOwnerDrawResult);
		return intReslut;
	}
	
	/**
	 * @author
	 * @param 
	 * @exception 删除本条信息
	 * 	3.0
	 * */
	public int deleteByPrimaryKey(int CatalogId) {
		int  intReslut = tbOwnerDrawResultMapper.deleteByPrimaryKey(CatalogId);
		return intReslut;
	}

	/**
	 * @author	3.0
	 * @param 
	 * @exception 更新本条信息
	 * */
	public int updateByPrimaryKeySelective(TbOwnerDrawResult TbOwnerDrawResult) {
		int  intReslut = tbOwnerDrawResultMapper.updateByPrimaryKeySelective(TbOwnerDrawResult);
		return intReslut;
	}

	public int updateAllDrawResultToGradezero() {
		int  intReslut = tbOwnerDrawResultMapper.updateAllDrawResultToGradezero();
		return intReslut;
	}
	
	public List<TbOwnerDrawResult> selectTbOwnerDrawResultAll() {
		List<TbOwnerDrawResult>  TbOwnerDrawResultList = tbOwnerDrawResultMapper.selectTbOwnerDrawResultAll();
		return TbOwnerDrawResultList;
	}

	public int deleteAll() {
		int  intReslut = tbOwnerDrawResultMapper.deleteAll();
		return intReslut;
	}

}
