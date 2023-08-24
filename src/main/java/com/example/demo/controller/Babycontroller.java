package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Babymodel;
import com.example.demo.service.Babyservice;

@RestController
public class Babycontroller {
	@Autowired
	Babyservice bs;
	@PostMapping("addnbaby")
	public List<Babymodel> addinfo(@RequestBody List<Babymodel> bm)
	{
		return bs.savedetails(bm);
	}
	//to get the data
	@GetMapping("showbaby")
	public List<Babymodel> show()
	{
		return bs.showinfo();
	}
	@GetMapping("sortbaby/{lastname}")
	public List<Babymodel> getsortinfo(@PathVariable String lastname)
	{
		return bs.sortinfo(lastname);
	}
	@GetMapping("pagingbaby/{pagno}/{pagsize}")
	public List<Babymodel> showpageinfo(@PathVariable int pagno,@PathVariable int pagsize)
	{
		return bs.getbypage(pagno, pagsize);
	}
	@GetMapping("getsortpagbaby/{pagno}/{pagsize}")
	public List<Babymodel> showsortpageinfo(@PathVariable int pagno,@PathVariable int pagsize)
	{
		return bs.getpage(pagno, pagsize);
	}

}
