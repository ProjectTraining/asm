package com.asm.service.impl;

import java.util.List;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.deptDao;
import com.asm.domain.Dept;
import com.asm.domain.User;
import com.asm.service.DeptService;
import com.asm.util.PageBean;


@Transactional(readOnly=false)
@Service("deptService")
public class DeptServiceImpl implements DeptService {
	@Autowired
	private deptDao deptdao;
	@Override
	public void regDept(Dept dept) {
		System.out.println("到这里了————"+dept.getDeptId());
		deptdao.saveDept(dept);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean delete(Dept dept) {
		try{
		System.out.println("---" + dept.getDeptId()+ "---" + dept.getDeptName());
		//this.deptdao.removeUser(dept);
		deptdao.deleteObjectByIds(dept.getDeptId());
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
    public List<Dept> findAllUsers() {  
        return this.deptdao.findAll();  
    }  
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void update(Dept dept) {
		this.deptdao.updateUser(dept);
	}
	@Override
	public Dept findDeptById(String id) {
		return this.deptdao.findObjectByID(id);
	}
/*	@Override
	public Dept checkDeptExist(String deptName) {
		// TODO Auto-generated method stub
		return deptdao.getDept(deptName);
	}*/
	@Override
	public boolean checkDeptExistByName(String deptName) {
		return deptdao.checkDeptExistByName(deptName);
	}
	@Override
	public boolean checkDeptExist(String deptName) {
		// TODO Auto-generated method stub
		return false;
	}
	/**   
	 * 分页查询     
	 * @param pageSize  每页显示多少记录   
	 * @param currentPage 当前页   
	 * @return 封装了分页信息的bean   
	 */    
	public PageBean queryForPage(int pageSize, int page) {
		final String hql = "from Dept d order by d.deptId asc"; // 查询语句
		int allRow = deptdao.getAllRowCount(hql); // 总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); // 总页数
		System.out.println("总共记录数："+totalPage);
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		int length = 0; // 每页记录数
		if(currentPage==totalPage){
			length=allRow-(currentPage-1)*pageSize;
		}else {
			length=pageSize;
		}
		List<Dept> list = deptdao.queryForPage(hql, offset, length); //得到在分页内的数据
		// 把分页信息保存到Bean当中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}
}
