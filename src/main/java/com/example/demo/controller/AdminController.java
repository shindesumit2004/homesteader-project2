package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.demo.service.GovernmentSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.*;
import com.example.demo.service.AdminService;
import com.example.demo.service.AgroService;
import com.example.demo.service.FarmService;

@Controller
public class AdminController {

	@Autowired
	private FarmService farmService;
	@Autowired
	private AgroService agroService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private GovernmentSchemeService governmentSchemeService;




	@RequestMapping("/admin")
	public String AdminLogin() {

		return "loginadmin";
	}

	@PostMapping("/adminmapping")
	public String Adminlogincheck(@RequestParam("name") String name,
	                              @RequestParam("password") String password,
	                              HttpSession h1,
	                              ModelMap mm) {

		/// Check Subadmin Login
		SubAdmin agroService = adminService.checksubadmin(name, password);

		if ("admin".equals(name) && "admin123".equals(password) || agroService != null) {

			h1.setAttribute("username", name);

			/// Farmer Count
			int totalApproveFarmer = (int) farmService.countApprovedFarmer();
			System.out.println("Total approved farmers: " + totalApproveFarmer);
			mm.addAttribute("count", totalApproveFarmer);

			/// Product Count
			int totalproduct = (int) this.agroService.countproduct();
			System.out.println("Total product =" + totalproduct);
			mm.addAttribute("countproduct", totalproduct);

			/// Agro Agency Count
			int totalagroagency = (int) this.agroService.countagroagency();
			System.out.println("Total Agroagency=" + totalagroagency);
			mm.addAttribute("countagro", totalagroagency);

			return "redirect:/admindash";
		}

		else {

			return "loginadmin";
		}
	}

	/// Mapping For Admin Dashboard
	@RequestMapping("/admindash")
	public String admindash(ModelMap mm, HttpSession h1) {

		String x = (String) h1.getAttribute("username");

		if (x == null) {

			return "loginadmin";
		}

		else {

			List<Contact> ca = farmService.DisplayContactAdmin();

			mm.addAttribute("kk", ca);

			/// Farmer Count
			int totalApproveFarmer = (int) farmService.countApprovedFarmer();
			System.out.println("Total approved farmers: " + totalApproveFarmer);
			mm.addAttribute("count", totalApproveFarmer);

			/// Product Count
			int totalproduct = (int) this.agroService.countproduct();
			System.out.println("Total product =" + totalproduct);
			mm.addAttribute("countproduct", totalproduct);

			/// Agro Agency Count
			int totalagroagency = (int) this.agroService.countagroagency();
			System.out.println("Total Agroagency=" + totalagroagency);
			mm.addAttribute("countagro", totalagroagency);

			return "admindash";
		}
	}

	/// Agro Agency Management

	/// Mapping For Pending Agro Agency List
	@RequestMapping("/adminagro")
	public String adminagrolist(ModelMap mm, HttpSession h1) {

		String check = (String) h1.getAttribute("username");

		if (check.equals("admin")) {

			List<Agro> ae = agroService.getPendingAgro();

			mm.addAttribute("kk", ae);

			return "adminagro";
		}

		return "permisson";
	}

	/// Mapping For Approved Agro Agency List
	@RequestMapping("/agropage")
	public String agroagencydisplayadmin(ModelMap mm) {

		List<Agro> a = agroService.getApproveAgro();

		mm.addAttribute("kk", a);

		return "agropage";
	}

	/// Mapping For Permission Page
	@RequestMapping("/permisson")
	public String permission() {

		return "permisson";
	}

	/// Mapping For Search Agro Agency
	@RequestMapping("/searchagro")
	public String actionagro(@RequestParam("name") String name,
	                         ModelMap mm) {

		List<Agro> ae = agroService.findbyname(name);

		mm.addAttribute("kk", ae);

		return "agroaction";
	}

	/// Mapping For Approve Agro Agency
	@PostMapping("/submitagro")
	public String approveagro(@ModelAttribute("c2") Agro c2,
	                          @RequestParam("file") MultipartFile filename)
			throws IOException {

		String f = filename.getOriginalFilename();

		String path = ("D:\\Homesteader2.0\\src\\main\\resources\\static\\certificate");

		BufferedOutputStream b = new BufferedOutputStream(
				new FileOutputStream(path + "/" + f));

		byte bt[] = filename.getBytes();

		b.write(bt);

		b.close();

		c2.setDocument(f);

		Agro s = new Agro();

		s.setId(c2.getId());
		s.setName(c2.getName());
		s.setEmail(c2.getEmail());
		s.setDocument(c2.getDocument());
		s.setDistrict(c2.getDistrict());
		s.setTown(c2.getTown());
		s.setPassword(c2.getPassword());
		s.setStatus(c2.getStatus());
		s.setAddress(c2.getAddress());

		agroService.registeragro(s);

		return "redirect:/adminagro";
	}

	/// Remove Agro Agency Request
	@RequestMapping("/reject/{id}")
	public String rejectagro(@PathVariable int id) {

		agroService.delete(id);

		return "redirect:/adminagro";
	}

	/// Remove Agro Agency Access
	@RequestMapping("/removeagro/{id}")
	public String RemoveAccess(@PathVariable int id) {

		agroService.delete(id);

		return "redirect:/agropage";
	}

	/// Product Management

	/// Mapping For Add Product Page
	@RequestMapping("/addproductadmin")
	public String Addproductadmin() {

		return "addproductadmin";
	}

	/// Mapping For Add New Product
	@PostMapping("/productadmin")
	public String addnewproduct(@ModelAttribute("c2") Product c2,
	                            @RequestParam("pfile") MultipartFile filename1)
			throws IOException {

		String f1 = filename1.getOriginalFilename();

		//String path1 = "C:\\Users\\gaura\\eclipse-workspace\\CravitaProject_HomeSteader\\src\\main\\resources\\static\\product";
		String path1 = "D:\\Homesteader2.0\\src\\main\\resources\\static\\product";

		BufferedOutputStream b1 = new BufferedOutputStream(
				new FileOutputStream(path1 + "/" + f1));

		byte bt1[] = filename1.getBytes();

		b1.write(bt1);

		b1.close();

		c2.setPfilen(f1);

		agroService.addnewproduct(c2);

		return "redirect:/viewproduct";
	}

	/// Mapping For Show All Products
	@RequestMapping("/editproductadmin")
	public String editproduct(ModelMap mm) {

		List<Product> pa = agroService.showallproductadmin();

		mm.addAttribute("kk", pa);

		return "editproductadmin";
	}

	/// Mapping For Search Product By Name
	@RequestMapping("/searchproductforedit")
	public String EditProductbyAdmin(@RequestParam("name") String name,
	                                 ModelMap mm) {

		List<Product> pd = agroService.updateproduct(name);

		mm.addAttribute("kk", pd);

		return "updateproduct";
	}

	/// Mapping For Update Product
	@PostMapping("/updateproduct")
	public String updateproductagro(@ModelAttribute("c3") Product c3,
	                                @RequestParam("pfile") MultipartFile filename1)
			throws IOException {

		String f1 = filename1.getOriginalFilename();

		String path1 = "D:\\Homesteader2.0\\src\\main\\resources\\static\\product";

		BufferedOutputStream b1 = new BufferedOutputStream(
				new FileOutputStream(path1 + "/" + f1));

		byte bt1[] = filename1.getBytes();

		b1.write(bt1);

		b1.close();

		c3.setPfilen(f1);

		Product p1 = new Product();

		p1.setId(c3.getId());
		p1.setPname(c3.getPname());
		p1.setPtype(c3.getPtype());
		p1.setPfilen(c3.getPfilen());
		p1.setPcprice(c3.getPcprice());
		p1.setPwprice(c3.getPwprice());

		agroService.addnewproduct(p1);

		return "redirect:/editproductadmin";
	}

	/// Mapping For Delete Product
	@RequestMapping("/deleteproduct/{id}")
	public String deleteproduct(@PathVariable int id) {

		agroService.deleteproduct(id);

		return "redirect:/editproductadmin";
	}

	/// Mapping For Update Product Page
	@RequestMapping("/updateproduct")
	public String updateproduct() {

		return "updateproduct";
	}

	/// Farmer Reports
	/// Mapping For Farmer Report
	@RequestMapping("/farmreport")
	public String farmerreport(ModelMap mm) {

		List<Enquiry> e = farmService.DisplayEnqiry();

		mm.addAttribute("k", e);

		return "farmreport";
	}

	/// Mapping For Farmer Report By Date
	@GetMapping("/reportget")
	public String reportgenerate(@RequestParam("startdate") Date startdate,
	                             @RequestParam("enddate") Date enddate,
	                             ModelMap mm) {

		List<Enquiry> e = farmService.reportget(startdate, enddate);

		mm.addAttribute("k", e);

		return "farmreport";
	}

	///Farmer Management

	/// Mapping For Show All Farmers
	@RequestMapping("/totalfarmeradmin")
	public String totalfarmerdisplay(ModelMap mm) {

		List<Farmer> li = farmService.showallfarmer();

		mm.addAttribute("kk", li);

		return "totalfarmeradmin";
	}

	/// Blog Management

	/// Mapping For Blog Upload Page
	@RequestMapping("/blog")
	public String Blogupload(ModelMap mm) {

		List<Blog> b = adminService.showallblog();

		mm.addAttribute("kk", b);

		return "blog";
	}

	/// Mapping For Upload Blog
	@PostMapping("/uploadblog")
	public String uploadblog(@ModelAttribute("c4") Blog c4,
	                         @RequestParam("blogfile") MultipartFile filename)
			throws IOException {

		String f1 = filename.getOriginalFilename();

		String path1 = "D:\\Homesteader2.0\\src\\main\\resources\\static\\blogimg";

		BufferedOutputStream b1 = new BufferedOutputStream(
				new FileOutputStream(path1 + "/" + f1));

		byte bt1[] = filename.getBytes();

		b1.write(bt1);

		b1.close();

		c4.setBlogimg(f1);

		adminService.blogupload(c4);

		return "redirect:/blog";
	}

	/// Mapping For Remove Blog
	@GetMapping("/removeblog/{id}")
	public String removeblog(@PathVariable int id) {

		adminService.deleteblog(id);

		return "redirect:/blog";
	}

	/// Mapping For Get Blog By Title
	@PostMapping("/blogget")
	public String getblog(@RequestParam("title") String title,
	                      ModelMap mm) {

		List<Blog> b = adminService.findblogbytittle(title);

		mm.addAttribute("kk", b);

		return "blogfarmer";
	}

	/// Mapping For Farmer Blog Page
	@RequestMapping("/blogfarmer")
	public String farmerblogshow() {

		return "blogfarmer";
	}

	/// Sub Admin Management
	/// Mapping For Register Subadmin Page
	@RequestMapping("/registersubadmin")
	public String registersubadminpage(HttpSession h1,
	                                   ModelMap mm) {

		String check = (String) h1.getAttribute("username");

		if (check.equals("admin")) {

			List<SubAdmin> ab = adminService.showallsubadmin();

			mm.addAttribute("kk", ab);

			return "registersubadmin";
		}

		return "permisson";
	}

	/// Mapping For Register Subadmin
	@PostMapping("/registersubad")
	public String subadmin(@ModelAttribute("c5") SubAdmin c5) {

		adminService.savasubadmin(c5);

		return "redirect:/registersubadmin";
	}


	@GetMapping("/removesubadmin/{id}")
	public String removesubadminaccess(@PathVariable int id) {

		adminService.removesubadminaccress(id);

		return "redirect:/registersubadmin";
	}




	@RequestMapping("/adminstudentrequest")
	public String studentadmin(ModelMap mm) {

		List<TrainingStudent> sr = farmService.Displaystudentreq();

		mm.addAttribute("kk", sr);

		return "adminstudentrequest";
	}


	@GetMapping("/reportgetstudent")
	public String reportgenerateStudent(@RequestParam("startdate") Date startdate,
	                                    @RequestParam("enddate") Date enddate,
	                                    ModelMap mm) {

		List<TrainingStudent> sr = farmService.reportgetstudent(startdate, enddate);

		mm.addAttribute("kk", sr);

		return "adminstudentrequest";
	}


	@RequestMapping("/adminfarmerrequest")
	public String farmertrainingadmin(ModelMap mm) {

		List<TrainingFarmer> fr = farmService.Displayfarmerreq();

		mm.addAttribute("kk", fr);

		return "adminfarmerrequest";
	}


	@GetMapping("/reportgetfarmer")
	public String reportgeneratefarmer(@RequestParam("startdate") Date startdate,
	                                   @RequestParam("enddate") Date enddate,
	                                   ModelMap mm) {

		List<TrainingFarmer> fr = farmService.reportgetfarmer(startdate, enddate);

		mm.addAttribute("kk", fr);

		return "adminfarmerrequest";
	}




	@RequestMapping("/soilreportadmin")
	public String showsoilreportadmin(ModelMap mm) {

		List<SoilAnalysis> agroService = farmService.showallreport();

		mm.addAttribute("kk", agroService);

		return "soilreportadmin";
	}


	@GetMapping("/reportsoil")
	public String soilreportger(@RequestParam("startdate") Date startdate,
	                            @RequestParam("enddate") Date enddate,
	                            ModelMap mm) {

		List<SoilAnalysis> agroService = farmService.soilreportget(startdate, enddate);

		mm.addAttribute("kk", agroService);

		return "soilreportadmin";
	}


	@RequestMapping("/agroaction")
	public String editagro() {

		return "agroaction";
	}


	@RequestMapping("/logoutadmin")
	public String logout(HttpSession h1) {

		h1.invalidate();

		return "loginadmin";
	}


	@RequestMapping("/mesagroServicege")
	public String mesagroServicegepage() {

		return "mesagroServicege";
	}


}