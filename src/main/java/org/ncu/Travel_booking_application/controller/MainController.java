package org.ncu.Travel_booking_application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.ncu.Travel_booking_application.BuyerDao.BuyerDao;
import org.ncu.Travel_booking_application.Entity.Hotel;
import org.ncu.Travel_booking_application.Entity.User;
import org.ncu.Travel_booking_application.SellerDao.SellerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@Autowired
	SellerDao Sdao;
	
	@Autowired
	BuyerDao Bdao;

	@ModelAttribute("User")
	public User returnuser(HttpServletRequest request)
	{
		return new User();
	}
	@ModelAttribute("Hotel")
	public Hotel returnhotel(HttpServletRequest request)
	{
		return new Hotel();
	}
	@RequestMapping("RemoveHotel")
	public String RemoveHotel(@RequestParam("hotelId")int id)
	{
		int rowsaffected=Bdao.removehotel(id);
		if(rowsaffected==1)
			System.out.println("Remove successfully!");
		else
			System.out.println("Error");
		return "redirect:/AlreadyAddedFormByBuyer";
	}
	
	@RequestMapping("SelectHotel")
	public String SelectHotel(@RequestParam("hotelId")int id,HttpServletRequest request,Model model)
	{
		HttpSession session=request.getSession();
		int Buyerid=(Integer) session.getAttribute("id");
		int rowsaffected = Bdao.addBuyer(id,Buyerid);
		if(rowsaffected==1)
		{
			System.out.println("Record Added To Buyer successfully!!");
		}else {
			System.out.println("Error!!!");
		}
//		List<Hotel> listofhotel = Bdao.getlist(0);
//		model.addAttribute("hotellist",listofhotel);
		return "redirect:/BuyerHotelList";
	}
	@RequestMapping("getsellerinterface")
	public String getSellerInterface()
	{
		return "SellerInterface";
	}
	@RequestMapping("getSellerProfile")
	public String getSellerProfile(Model model,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		int id=(Integer) session.getAttribute("id");
		User user=Sdao.getSeller(id);
		model.addAttribute("User", user);
//		System.out.println(user);
		return "ProfileBySeller";
	}
	@RequestMapping("BuyerHotelList")
	public String BuyerHotelList(@ModelAttribute("Hotel")Hotel obj,Model model)
	{
		String Search=obj.getSearch();
		List<Hotel> listofhotel = Bdao.getlist(0);
		if(Search==null)
			Search="";
		if(!Search.equals(""))
		{
			List<Hotel>array=new ArrayList<Hotel>();
			for(Hotel obj1 : listofhotel)
			{
				String HotelId=obj1.getHotelId()+"";
				String Price=obj1.getPrice()+"";
				String Duration=obj1.getDuration()+"";
				String Rating=obj1.getRating()+"";
				int flag=0;
				if(obj1.getHotelName().toLowerCase().contains(Search.toLowerCase()) || obj1.getHotelLocation().toLowerCase().contains(Search.toLowerCase()) ||HotelId.contains(Search)||Price.contains(Search)||Duration.contains(Search)||Rating.contains(Search))
				{
					flag=1;
				}
				if(flag==0)
				{
					array.add(obj1);
				}
			}
			for(Hotel obj1: array)
			{
				listofhotel.remove(obj1);
			}
		}
		model.addAttribute("hotellist",listofhotel);
		return "BuyerList";
	}
	@RequestMapping("AlreadyAddedFormByBuyer")
	public String AlreadyAddedFormByBuyer(@ModelAttribute("Hotel")Hotel obj,Model model,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		int id=(Integer) session.getAttribute("id");
		String Search=obj.getSearch();
		List<Hotel> listofhotel = Bdao.getlist(id);
		if(Search==null)
			Search="";
		if(!Search.equals(""))
		{
			List<Hotel>array=new ArrayList<Hotel>();
			for(Hotel obj1 : listofhotel)
			{
				String HotelId=obj1.getHotelId()+"";
				String Price=obj1.getPrice()+"";
				String Duration=obj1.getDuration()+"";
				String Rating=obj1.getRating()+"";
				int flag=0;
				if(obj1.getHotelName().toLowerCase().contains(Search.toLowerCase()) || obj1.getHotelLocation().toLowerCase().contains(Search.toLowerCase()) ||HotelId.contains(Search)||Price.contains(Search)||Duration.contains(Search)||Rating.contains(Search))
				{
					flag=1;
				}
				if(flag==0)
				{
					array.add(obj1);
				}
			}
			for(Hotel obj1: array)
			{
				listofhotel.remove(obj1);
			}
		}
		model.addAttribute("hotellist",listofhotel);
		return "BuyerAlreadyAddedHotel";
	}
	@RequestMapping("getBuyerProfile")
	public String getBuyerProfile()
	{
		return "BuyerProfile";
	}	
	@RequestMapping("RegisterForm")
	public String getRegisterSeller()
	{
//		return "RegisterForm";
		return "Register2";
	}
	@RequestMapping("LoginForm")
	public String getLoginForm(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		session.invalidate();
//		return "LoginForm";
		return "Login2";
	}
	@RequestMapping("ModifySellerList")
	public String getmodifysellerlist(@ModelAttribute("Hotel")Hotel obj,HttpServletRequest request,Model model)
	{
		HttpSession session=request.getSession();
		int id=(Integer) session.getAttribute("id");
		List<Hotel> listofhotel = Sdao.getlist(id);
		model.addAttribute("hotellist", listofhotel);
		return "SellerModify";
	}
	@RequestMapping("AfterRegister")
    public String AfterRegister(@Valid @ModelAttribute("User") User obj,BindingResult bindingresult)
    {
        if(bindingresult.hasErrors())
        {
            return "Register2";
        }
        else {
            if(obj.getType().equals("Seller"))
            {
            if(Sdao.objcheck(obj)==0) 
            {
                Sdao.insertRecord(obj);
                return "Login2";
            }
            else
            {
                System.out.println("Already Present");
                return "Register2";
            }

        }
        else
        {
            if(Bdao.objcheck(obj)==0)
            {
                Bdao.insertRecord(obj);
                return "Login2";
            }
            else
            {
                System.out.println("Already Present");
//                return "RegisterForm";
                return "Register2";
            }
        }
        }

    }
	@RequestMapping("SellerModifySearch")
	public String getSellerModifySearch(@ModelAttribute("Hotel") Hotel obj,HttpServletRequest request,Model model)
	{
		String Search=obj.getSearch();
		if(Search.equals(""))
		{
			HttpSession session=request.getSession();
			int id=(Integer) session.getAttribute("id");
			List<Hotel> listofhotel = Sdao.getlist(id);
			model.addAttribute("hotellist", listofhotel);
		}
		else
		{
			HttpSession session=request.getSession();
			int id=(Integer) session.getAttribute("id");
			List<Hotel> listofhotel = Sdao.getSearch(Search,id);
			model.addAttribute("hotellist", listofhotel);
		}
		return "SellerModify";
	}
	@RequestMapping("AfterSellerSearch")
	public String getSellerAfterSearch(@ModelAttribute("Hotel") Hotel obj,HttpServletRequest request,Model model)
	{
		String Search=obj.getSearch();
		if(Search.equals(""))
		{
			HttpSession session=request.getSession();
			int id=(Integer) session.getAttribute("id");
			List<Hotel> listofhotel = Sdao.getlist(id);
			model.addAttribute("hotellist", listofhotel);
		}
		else
		{
			HttpSession session=request.getSession();
			int id=(Integer) session.getAttribute("id");
			List<Hotel> listofhotel = Sdao.getSearch(Search,id);
			model.addAttribute("hotellist", listofhotel);
		}
		return "Seller";
	}
	@RequestMapping("deleteHotel")
	public String deleteHotel(@RequestParam("HotelId")int id)
	{
		System.out.println("inside Delete with ID :"+id);
		int rowsaffected=Sdao.deleteRecord(id);;
		if(rowsaffected==1)
		{
			System.out.println("Record Deleted successfully!!");
		}else {
			System.out.println("Error!!!");
		}
		return "redirect:/ModifySellerList";
	}
	@RequestMapping("SellerList")
	public String getSeller(HttpServletRequest request,Model model)
	{
		HttpSession session=request.getSession();
		int id=(Integer) session.getAttribute("id");
		List<Hotel> listofhotel = Sdao.getlist(id);
		model.addAttribute("hotellist", listofhotel);
		return "Seller";
	}
	@RequestMapping("AfterLogin")
	public String AfterLogin(@ModelAttribute("User") User obj,HttpServletRequest request,Model model)
	{
		HttpSession session = request.getSession();
		if(obj.getType().equals("Seller"))
		{		
			if(Sdao.objcheck(obj)==1)
			{
				int id=Sdao.getSellerId(obj);
				obj.setId(id);
				session.setAttribute("id", id);
				System.out.println(obj.getId());
				List<Hotel> listofhotel = Sdao.getlist(obj.getId());
				for(Hotel ob:listofhotel)
				{
					System.out.println(ob);
				}
				model.addAttribute("hotellist",listofhotel);
				return "SellerInterface";
			}
			else
			{
				System.out.println("Invalid Credentials");
				return "Login2";
			}
		}
		else
		{
			if(Bdao.objcheck(obj)==1)
			{
				int id=Bdao.getBuyerId(obj);
				session.setAttribute("id", id);
				return "BuyerInterface";
			}
			else
			{
				System.out.println("Invalid Credentials");
				return "Login2";
			}
		}
	}

	@RequestMapping("addHotelForm")
	public String getHotelInputForm()
	{
		return "AddHotelBySeller"; 				
	}
	@RequestMapping("AfterAddingHotelBySeller")
	public String AfterAddingHotelBySeller(@ModelAttribute("Hotel") Hotel obj,@ModelAttribute("User") User userobj,Model model,HttpServletRequest request)
	{	
		HttpSession session = request.getSession();
		int id=(Integer) session.getAttribute("id");
		int done=Sdao.InsertHotelRecord(obj,id);
		if(done==0)
			System.out.println("Insertion of Hotel Record failed!!");
		System.out.println(userobj.getId());
		List<Hotel> listofhotel = Sdao.getlist(id);
		model.addAttribute("hotellist", listofhotel);
		return "SellerInterface";
	}
	@RequestMapping("updateHotel")
	public String updateHotel(@RequestParam("HotelId")int id,Model model)
	{
		Hotel obj=Sdao.getHotel(id);
		model.addAttribute("Hotel",obj);
		return "EditHotelBySeller";
	}
	@RequestMapping("afterupdateHotel")
	public String afterupdateHotel(@ModelAttribute("Hotel") Hotel obj,HttpServletRequest request,Model model)
	{
		int rowsaffected=Sdao.updateHotel(obj);
		if(rowsaffected==1)
		{
			System.out.println("Record Updated successfully!!");
		}else {
			System.out.println("Error!!!");
		}
		HttpSession session=request.getSession();
		int id1=(Integer) session.getAttribute("id");
		List<Hotel> listofhotel = Sdao.getlist(id1);
		model.addAttribute("hotellist", listofhotel);
		return "SellerModify";
	}
}
