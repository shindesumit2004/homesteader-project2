package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import com.example.demo.entity.Agro;
import com.example.demo.entity.Product;
import com.example.demo.service.AgroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.FarmService;
import com.example.demo.entity.SoilAnalysis;
import com.example.demo.entity.Blog;
import com.example.demo.service.AdminService;

@RestController
public class AgroController {

	@Autowired
	AgroService agroService;
	@Autowired
	FarmService farmService;
	@Autowired
	AdminService adminService;
	                                   
	///Mapping for Homepage
	@RequestMapping("/agro")
	public String agrohomepage(ModelMap mm)
	{
		///for Blog
        List<Blog> b=adminService.showallblog();
		mm.addAttribute("kk",b);
		return "Agrohome";
	}
	
	///Mapping for RegsiterPage
	@RequestMapping("/registeragro")
	public String registeragro()
	{
		return "registeragro";
	}
	
	///Mapping for LoginPage
	@RequestMapping("/loginagro")
	public String loginagro()
	{
		return "loginagro";
	}
	
	@RequestMapping("/verification")
	public String verification()
	{
		return "verification";
	}

	///Mapping for Agroagency Registration
	@PostMapping("/agro")
	public String agroagencyRegisterprocess(@ModelAttribute("c1") Agro c1, @RequestParam("email") String email, @RequestParam("file") MultipartFile filename) throws IOException
	{
		String f=filename.getOriginalFilename();
		String path=("D:\\Homesteader2.0\\src\\main\\resources\\static\\certificate");
		BufferedOutputStream b= new BufferedOutputStream(new FileOutputStream(path+"/"+f));
		byte bt [] =filename.getBytes();
		b.write(bt);
	    b.close();
	    
	    c1.setDocument(f);
	    
	 Agro ae  =agroService.checkemailagro(email);
	 
	 if(ae==null)
	 {
		 agroService.registeragro(c1);
	    return "loginagro";
	 }
	 return "registeragro";
	}

	///Mapping for Cheking Login Details
	@PostMapping("/agrologin")
	public String checkAgroLogin(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession h1)
	{
	Agro ae = agroService.CheckLoginagro(email, password);
	
	if(ae==null)
	{
		return "redirect:/loginagro";
	}
	else
	{
		h1.setAttribute("aname", ae.getName());
		if (ae.getStatus().equals("pending")) {
			return "verification";
		}
		else
		{
			return "agroWelcome";
		}
	}

}

     ///Mapping for Homepage AfterLogin
		@RequestMapping("/agroWelcome")
	    public String agroWelcome(HttpSession h1)
	    {
	    String x=(String) h1.getAttribute("aname");
	    
	    if(x==null)
	    {
	    	return "redirect:/loginagro";
	    }
	    else 
	    {
			return "agroWelcome";
		}
		}
	
	///Mapping for Logout
	@RequestMapping("/logoutagro")
	public String logoutagro(HttpSession h1) {
		h1.invalidate();
		return "loginagro";
	}

	///Mapping for Agro Dashboard
    @RequestMapping("/Dashagro")	
	public String dashboardagro()
	{
		return "Dashagro";
	}

	///Mapping for Headerfile
	@RequestMapping("/headeragro")
	public String agroheader()
	{
		return"headeragro";
	}
	
	///Dashboard Start
	///Mapping for addproduct page
	@RequestMapping("/addproduct")
	public String  addproduct()
	{
		return "addproduct";
	}
	
	///Mapping for Add New Product
	@PostMapping("/product")
	public String addnewproduct(@ModelAttribute("c2") Product c2, @RequestParam("pfile")MultipartFile filename1) throws IOException
	{
		String f1=filename1.getOriginalFilename();
		String path1="D:\\Homesteader2.0\\src\\main\\resources\\static\\product";
		BufferedOutputStream b1= new BufferedOutputStream( new FileOutputStream(path1+"/"+f1));
		byte bt1 [] =filename1.getBytes();
		b1.write(bt1);
	    b1.close();
		c2.setPfilen(f1);
		agroService.addnewproduct(c2);
		
		return "Dashagro";
	}
	
	@RequestMapping("/viewproduct")
	public String viewproduct(ModelMap m)
	{
	 List<Product> p=agroService.showallproduct();
	 m.addAttribute("kp",p);
	    return "viewproduct";
	}
	
	///Mapping For Product page Farmer Module for Shwoing Product
	@RequestMapping("/product")
		public String product(ModelMap mm) {
		List<Product> pf=agroService.showallproductfarmer();
		mm.addAttribute("kf",pf);
		  return "product";
	 }
	
	//Mapping for Showing all Product and Search Farmer Module
	@RequestMapping("/farmproduct")
	public String viewallproductfinal(ModelMap m)
	{
		List<Product> ps=agroService.showallpage();
		m.addAttribute("ks",ps);
		return "farmproduct";
	}
	
	///Mapping for Serach Product or Type Farmer Module
	@RequestMapping("/search")
	public String serac(@RequestParam("name") String name,@RequestParam ("type") String type,ModelMap mm)
	{
		List<Product> ps=agroService.serch(name,type);
		mm.addAttribute("ks",ps);
		return "farmproduct";
	}
	
	///Mapping for Get Single Product Agro
	@RequestMapping("/searchproductagroforedit")
	public String EditProductbyAdmin(@RequestParam ("name") String name,ModelMap mm)
	{
		List<Product> pd=agroService.updateproduct(name);
		mm.addAttribute("kk",pd);
		return "updateproductagro";
	}
	
	///Mapping for Get Updating Product Agroagency
	@PostMapping("/updateproductagro")
	public String updateproductagro(@ModelAttribute ("c3") Product c3, @RequestParam("pfile")MultipartFile filename1) throws IOException
	{
		String f1=filename1.getOriginalFilename();
		String path1="D:\\Homesteader2.0\\src\\main\\resources\\static\\product";
		BufferedOutputStream b1= new BufferedOutputStream( new FileOutputStream(path1+"/"+f1));
		byte bt1 [] =filename1.getBytes();
		b1.write(bt1);
	    b1.close();
		c3.setPfilen(f1);

	    Product p1= new Product();
	    p1.setId(c3.getId());
	    p1.setPname(c3.getPname());
	    p1.setPtype(c3.getPtype());
	    p1.setPfilen(c3.getPfilen());
	    p1.setPcprice(c3.getPcprice());
	    p1.setPwprice(c3.getPwprice());
	    
	    agroService.addnewproduct(p1);
	    
		return "redirect:/viewproduct";
	}
	
	///Mapping for delete product by id
	@RequestMapping("/deleteproductagro/{id}")
	public String deleteproduct(@PathVariable int id)
	{
		agroService.deleteproduct(id);
		return "redirect:/viewproduct";
	}
	
	///Mapping for Show Soil Request Agro
	@RequestMapping("/soilrequestfarmeragro")
	public String getsoilanalysisreport(ModelMap mm)
	{
	 List<SoilAnalysis> se=farmService.showallreport();
	 mm.addAttribute("kk",se);

	   return "soilrequestfarmeragro";
	}
	
	///Mapping for Update Page
	@RequestMapping("/updateproductagro")
	public String updateproduct()
	{
		return "updateproductagro";
	}
}
