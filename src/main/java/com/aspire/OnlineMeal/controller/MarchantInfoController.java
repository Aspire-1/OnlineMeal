package com.aspire.OnlineMeal.controller;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aspire.OnlineMeal.model.MarchantInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;
import com.aspire.OnlineMeal.service.IMarchantInfoService;

@RestController
@RequestMapping(value = "/MarchantInfo")
public class MarchantInfoController {

	@Autowired
	private IMarchantInfoService imis = null;

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResultMessage add(MarchantInfo marchantInfo) throws Exception {

		ResultMessage result = new ResultMessage();

		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		marchantInfo.setRegistTime(sdf.format(new Date()));

		imis.add(marchantInfo);

		result.setResult("Y");
		result.setMessage("添加商家信息成功");

		return result;

	}

	@RequestMapping(value="/add/selective",method=RequestMethod.POST)
	public ResultMessage addWithSelective(MarchantInfo marchantInfo,MultipartFile uploadphoto,HttpSession session) throws Exception {

		ResultMessage result = new ResultMessage();

		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		marchantInfo.setRegistTime(sdf.format(new Date()));

		if(uploadphoto!=null&&(!uploadphoto.isEmpty())){
		   String fileName=uploadphoto.getOriginalFilename();
		   String contentType=uploadphoto.getContentType();
		   ServletContext application=session.getServletContext();
		   
		   String path=application.getRealPath("/upload/marchant"+fileName);
		   uploadphoto.transferTo(new File(path));
		   
		   marchantInfo.setPhoto(uploadphoto.getBytes());
		   marchantInfo.setPhotoFileName(fileName);
		   marchantInfo.setPhotoContentType(contentType);
		   marchantInfo.setPhotoSrc("./upload/marchant"+fileName);
		}
		
		imis.addWithSelective(marchantInfo);

		result.setResult("Y");
		result.setMessage("添加商家信息成功");

		return result;

	}
	
	@RequestMapping(value="/modify/state")
	public ResultMessage modifyMarchantState(MarchantInfo marchantInfo) throws Exception{
		
		ResultMessage result = new ResultMessage();
		
		//前端传过指定的状态值来更改状态 例如 01 正常 02 休息中 03 接单中
		imis.modifyMarthantState(marchantInfo);
		
		result.setResult("Y");
		result.setMessage("修改商家状态成功");
		
		return result;
		
	}
	
	@RequestMapping(value="/modify")
	public ResultMessage modifyMarchantInfo(MarchantInfo marchantInfo,MultipartFile uploadphoto,HttpSession session) throws Exception{
		
		ResultMessage result = new ResultMessage();
		if(uploadphoto!=null&&(!uploadphoto.isEmpty())){
		   String fileName=uploadphoto.getOriginalFilename();
		   String contentType=uploadphoto.getContentType();
		   ServletContext application=session.getServletContext();
		   
		   String path=application.getRealPath("/upload/marchant/"+fileName);
		   uploadphoto.transferTo(new File(path));
		   
		   marchantInfo.setPhoto(uploadphoto.getBytes());
		   marchantInfo.setPhotoFileName(fileName);
		   marchantInfo.setPhotoContentType(contentType);
		   marchantInfo.setPhotoSrc("./upload/marchant/"+fileName);
		}
		imis.modifyMarthantState(marchantInfo);
		
		result.setResult("Y");
		result.setMessage("修改商家信息成功");
		
		return result;
		
	}
	
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public MarchantInfo getById(BigDecimal id) throws Exception{
		return imis.getByPrimaryKey(id);
	}
	
	@RequestMapping(value="/get/type",method=RequestMethod.POST)
	public List<MarchantInfo> getByType(String type) throws Exception{
		return imis.getMarchantByType(type);
	}
	
	@RequestMapping(value="/get/vagueName",method=RequestMethod.POST)
	public List<MarchantInfo> getByName(String name) throws Exception{
		return imis.getWithVagueName(name);
	}
	
	@RequestMapping(value="/get/all",method=RequestMethod.GET)
	public List<MarchantInfo> getAll() throws Exception{
		return imis.getAll();
	}
	
}
