package com.aspire.OnlineMeal.controller;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aspire.OnlineMeal.model.DishedInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;
import com.aspire.OnlineMeal.service.IDishedInfoService;

@RestController
@RequestMapping(value="/DishedInfo")
public class DishedInfoController {
	
	@Autowired
	private IDishedInfoService idis = null;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResultMessage add(DishedInfo dishedInfo) throws Exception{
		ResultMessage result = new ResultMessage();
		
		idis.addDished(dishedInfo);
		result.setResult("Y");
		result.setMessage("添加菜肴信息成功");
		
		return result;
		
	}
	
	@RequestMapping(value="/add/selective",method=RequestMethod.POST)
	public ResultMessage addWithSelective(DishedInfo dishedInfo,MultipartFile uploadphoto,HttpSession session) throws Exception{
		ResultMessage result = new ResultMessage();
		if(uploadphoto!=null&&(!uploadphoto.isEmpty())){
		   String fileName=uploadphoto.getOriginalFilename();
		   String contentType=uploadphoto.getContentType();
		   ServletContext application=session.getServletContext();
		   
		   String path=application.getRealPath("/upload/"+fileName);
		   uploadphoto.transferTo(new File(path));
		   
		   dishedInfo.setPhoto(uploadphoto.getBytes());
		   dishedInfo.setPhotoFileName(fileName);
		   dishedInfo.setPhotoContentType(contentType);
		   dishedInfo.setPhotoSrc("/upload/"+fileName);
		}
		
		idis.addDishedWithSelective(dishedInfo);
		result.setResult("Y");
		result.setMessage("添加菜肴信息成功");
		
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ResultMessage deleteDished(BigDecimal id) throws Exception{
		ResultMessage result = new ResultMessage();
		
		idis.deleteDished(id);
		result.setResult("Y");
		result.setMessage("删除菜肴信息成功");
		
		return result;
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public ResultMessage modifyDished(DishedInfo dishedInfo,MultipartFile uploadphoto,HttpSession session) throws Exception{
		ResultMessage result = new ResultMessage();
		if(uploadphoto!=null&&(!uploadphoto.isEmpty())){
		   String fileName=uploadphoto.getOriginalFilename();
		   String contentType=uploadphoto.getContentType();
		   ServletContext application=session.getServletContext();
		   
		   String path=application.getRealPath("/upload/"+fileName);
		   uploadphoto.transferTo(new File(path));
		   
		   dishedInfo.setPhoto(uploadphoto.getBytes());
		   dishedInfo.setPhotoFileName(fileName);
		   dishedInfo.setPhotoContentType(contentType);
		   dishedInfo.setPhotoSrc("/upload/"+fileName);
		}
			
		idis.modifyDished(dishedInfo);
		result.setResult("Y");
		result.setMessage("修改菜肴信息成功");
		
		return result;
	}
	
	//根据类型编号查找
	@RequestMapping(value="/get/byDishedType",method=RequestMethod.POST)
	public List<DishedInfo> getDishedWithDishedType(DishedInfo dishedInfo) throws Exception{
		return idis.getDishedWithDishedType(dishedInfo);
	}
	
	//根据类型名称模糊查找
	@RequestMapping(value="/get/vagueName",method=RequestMethod.POST)
	public List<DishedInfo> getWithVagueName(DishedInfo dishedInfo) throws Exception{
		return idis.getWithVagueName(dishedInfo);
	}
	
	//查出所有的菜肴信息
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public List<DishedInfo> getAll(BigDecimal marchantId) throws Exception{
		return idis.getAll(marchantId);
	}
	
	//分页查找出所有的菜肴信息
	@RequestMapping(value="/get/page",method=RequestMethod.POST)
	public ResultInfo getAllWithPage(
			@RequestParam(required=false,defaultValue="3") int rows,
			@RequestParam(required=false,defaultValue="1") int page,
			BigDecimal marchantId) throws Exception{
		ResultInfo result = new ResultInfo();
		result.setCount(idis.getCountByAll(marchantId));
		result.setPageCount(idis.getPageCountByAll(rows,marchantId));
		result.setRows(rows);
		result.setPage(page);
		result.setList(idis.getAllWithPage(rows, page,marchantId));
		   
		return result;
	}


}
