package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;

import com.example.demo.entity.*;
import com.example.demo.entity.Agro;
import com.example.demo.entity.Blog;
import com.example.demo.entity.Product;
import com.example.demo.service.AdminService;
import com.example.demo.service.AgroService;
import com.example.demo.service.FarmService;

@Controller
public class FarmController {


	private int cnt;
	@Autowired
	private FarmService farmService;
	@Autowired
	private AgroService agroService;
	@Autowired
	private AdminService adminService;


	@RequestMapping("/farm")
	public String Home(ModelMap mm) {


		List<Product> pl = agroService.showallpage();
		mm.addAttribute("k", pl);


		List<Blog> b = adminService.showallblog();
		mm.addAttribute("kk", b);

		return "index";
	}


	@RequestMapping("/register")
	public String Register() {

		return "register";
	}

	/// Mapping For Register Farmer Data
	@Operation(description = "Register Foor ")
	@PostMapping("/regfarmer")
	public String regfarmer(@ModelAttribute("c1") Farmer c1,
	                        @RequestParam("email") String email,
	                        ModelMap m,
	                        HttpSession h1) {

		/// Check Duplicate Email
		Farmer a = farmService.checkemail(email);

		if (a == null) {

			cnt++;

			h1.setAttribute("cnt", cnt);

			farmService.Register(c1);

			return "login";
		}

		return "register";
	}

	/// Mapping For Login Page
	@RequestMapping("/login")
	public String Login() {

		return "login";
	}

	/// Mapping For Login Validation
	@PostMapping("/loginfarm")
	public String logincheck(@RequestParam("email") String email,
	                         @RequestParam("password") String password,
	                         HttpSession h1) {

		Farmer a = farmService.logindetails(email, password);

		if (a == null) {

			return "redirect:/login";
		}

		else {

			/// Store Farmer Session Data
			h1.setAttribute("name", a.getName());
			h1.setAttribute("email", a.getEmail());
			h1.setAttribute("mobile", a.getMobile());
			h1.setAttribute("state", a.getState());
			h1.setAttribute("city", a.getCity());
			h1.setAttribute("Town", a.getTown());
			h1.setAttribute("village", a.getVillage());
			h1.setAttribute("soil", a.getSoiltype());
			h1.setAttribute("id", a.getId());
			h1.setAttribute("password", a.getPassword());

			return "redirect:/home";
		}
	}

	/// Mapping For Farmer Profile Activities
	@RequestMapping("/searchname")
	public String profilefarmer(@RequestParam("email") String email,
	                            ModelMap mm,
	                            HttpSession h3) {

		List<Farmer> l = farmService.findfarmerbyemail(email);

		List<Enquiry> l2 = farmService.findenqiryfarmer(email);

		List<SoilAnalysis> l3 = farmService.findsoilfarmer(email);

		List<TrainingFarmer> l4 = farmService.findfarmertraining(email);

		mm.addAttribute("k", l2);

		mm.addAttribute("kk", l);

		mm.addAttribute("kkk", l3);

		mm.addAttribute("kkkk", l4);

		return "profilefarmer";
	}

	/// Mapping For Profile Page
	@RequestMapping("/profilefarmer")
	public String profilepage() {

		return "profilefarmer";
	}

	/// Update Farmer Profile
	@PostMapping("/setprofile")
	public String setprofile(@ModelAttribute("c2") Farmer c2) {

		Farmer f = new Farmer();

		f.setId(c2.getId());
		f.setName(c2.getName());
		f.setEmail(c2.getEmail());
		f.setMobile(c2.getMobile());
		f.setState(c2.getState());
		f.setCity(c2.getCity());
		f.setVillage(c2.getVillage());
		f.setTown(c2.getTown());
		f.setPassword(c2.getPassword());
		f.setSoiltype(c2.getSoiltype());

		farmService.Register(f);

		return "home";
	}

	/// Generate Soil Analysis PDF
	@RequestMapping("/getpdf")
	public String getsoildata(@RequestParam("email") String email,
	                          ModelMap mm) {

		List<SoilAnalysis> l4 = farmService.findsoilfarmer(email);

		mm.addAttribute("k", l4);

		return "pdfget";
	}

	/// Withdraw Soil Analysis Request
	@RequestMapping("/withdraw/{id}")
	public String removesoilanalysisrequest(@PathVariable int id) {

		farmService.withdrawrequest(id);

		return "redirect:/home";
	}

	/// Mapping For Home Page After Login
	@RequestMapping("/home")
	public String home(HttpSession h1, ModelMap mm) {

		String name = (String) h1.getAttribute("name");

		if (name == null) {

			return "redirect:/login";
		}

		/// Fetch All Products
		List<Product> pl = agroService.showallpage();
		mm.addAttribute("k", pl);

		/// Fetch All Blogs
		List<Blog> b = adminService.showallblog();
		mm.addAttribute("kk", b);

		return "home";
	}

	/// Mapping For Logout
	@RequestMapping("/logout")
	public String logout(HttpSession h1) {

		h1.invalidate();

		return "redirect:/login";
	}

	/// Mapping For Farmer Training Page
	@RequestMapping("/farmtrain")
	public String farmtrain() {

		return "farmtrain";
	}

	/// Mapping For Training Submit Page
	@RequestMapping("/trainingsubmit")
	public String trainingsubmit() {

		return "trainingsubmit";
	}

	/// Mapping For Product Enquiry Page
	@RequestMapping("/enquiryproduct")
	public String enquiryproduct() {

		return "enquiryproduct";
	}

	/// Mapping For Student Training Page
	@RequestMapping("/stutrain")
	public String studenttraining() {

		return "stutrain";
	}

	/// Mapping For Contact Page
	@RequestMapping("/contact")
	public String contact() {

		return "contact";
	}

	/// Save Farmer Training Form
	@PostMapping("/ram")
	public String training_Response(@ModelAttribute("c2") TrainingFarmer c2) {

		farmService.submittraining(c2);

		return "farmtrain";
	}

	/// Save Student Training Form
	@PostMapping("/student")
	public String Student_response(@ModelAttribute("c3") TrainingStudent c3) {

		farmService.submitstudentrs(c3);

		return "redirect:/home";
	}

	/// Search Product By Name
	@RequestMapping("/productsearch")
	public String getproductname(@RequestParam("name") String name,
	                             ModelMap mm) {

		List<Product> pa = agroService.findbynameproduct(name);

		mm.addAttribute("kk", pa);

		return "enquiryproduct";
	}

	/// Save Enquiry Form
	@PostMapping("/enqiryservice")
	public String EnquiryDetails(@ModelAttribute("c4") Enquiry c4) {

		farmService.submitenquiry(c4);

		return "redirect:/farmproduct";
	}

	/// Save Contact Details
	@PostMapping("/contact")
	private String contact(@ModelAttribute("c4") Contact c4) {

		farmService.contactus(c4);

		return "home";
	}

	/// Show Farmer Training Requests
	@RequestMapping("/farmdisplay")
	public String showfarmerreq(ModelMap mm) {

		List<TrainingFarmer> t1 = farmService.Displayfarmerreq();

		mm.addAttribute("kk", t1);

		return "farmdisplay";
	}

	/// Show Student Training Requests
	@RequestMapping("/studisplay")
	public String showstudentreq(ModelMap m) {

		List<TrainingStudent> t2 = farmService.Displaystudentreq();

		m.addAttribute("kk", t2);

		return "studisplay";
	}

	/// Show Enquiry Data
	@RequestMapping("/enqirydisplay")
	public String showEnqnqiry(ModelMap mm) {

		List<Enquiry> listen = farmService.DisplayEnqiry();

		mm.addAttribute("ke", listen);

		return "enqirydisplay";
	}

	/// Mapping For Soil Analysis Page
	@RequestMapping("/soilfarmer")
	public String soilanalysisfarmer() {

		return "soilfarmer";
	}

	/// Save Soil Analysis Response
	@PostMapping("/savesoilresponse")
	public String savesoilanalysisresponse(@ModelAttribute("c6") SoilAnalysis c6,
	                                       @RequestParam("semail") String semail,
	                                       HttpSession h3) {

		SoilAnalysis soil = farmService.checksoildublicate(semail);

		if (soil == null) {

			farmService.soilsave(c6);

			/// Store Soil Data In Session
			h3.setAttribute("sid", c6.getId());
			h3.setAttribute("sname", c6.getSname());
			h3.setAttribute("slocation", c6.getSlocation());
			h3.setAttribute("smobile", c6.getSmobile());
			h3.setAttribute("semail", c6.getSemail());
			h3.setAttribute("sdepth", c6.getSdepth());
			h3.setAttribute("stype", c6.getStype());
			h3.setAttribute("sorganic", c6.getSorganic());
			h3.setAttribute("stexture", c6.getStexture());
			h3.setAttribute("scrop", c6.getScrop());
			h3.setAttribute("spcrop", c6.getSpcrop());
			h3.setAttribute("sfertilizer", c6.getSfertilizer());
			h3.setAttribute("sirrigation", c6.getSirrigation());
			h3.setAttribute("sdate", c6.getSdate());
			h3.setAttribute("scomments", c6.getScomments());

			return "pdfgenerate";
		}

		return "soilaction";
	}

	/// Mapping For Soil Action Page
	@RequestMapping("/soilaction")
	public String soilrequest() {

		return "soilaction";
	}

	/// Mapping For PDF Generate Page
	@RequestMapping("/pdfgenerate")
	public String pdfpage() {

		return "pdfgenerate";
	}

	/// Show All Approved Agro Agencies
	@RequestMapping("/farmagroagency")
	public String agroshowfarmer(ModelMap mm) {

		List<Agro> a = agroService.getApproveAgro();

		mm.addAttribute("kk", a);

		return "farmagroagency";
	}

	/// Mapping For About Page
	@RequestMapping("/about")
	public String about() {

		return "about";
	}

	/// Mapping For About Page After Login
	@RequestMapping("/aboutl")
	public String aboutl() {

		return "aboutl";
	}

	/// Mapping For Service Page
	@RequestMapping("/service")
	public String service() {

		return "service";
	}

	/// Mapping For Header File
	@RequestMapping("/headerfile")
	public String headerfile() {

		return "headerfile";
	}

	/// Mapping For Footer Section
	@RequestMapping("/footer")
	public String footer() {

		return "footer";
	}
}