package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Babymodel;
import com.example.demo.repository.Babyrepo;

@Service
public class Babyservice {
	@Autowired
	Babyrepo br;
	public List<Babymodel> savedetails(List<Babymodel> bm)
	{
		return (List<Babymodel>)br.saveAll(bm);
	}
	public List<Babymodel> showinfo(){
		return br.findAll();
	}
	public List<Babymodel> sortinfo(String s)
	{
		return br.findAll(Sort.by(Sort.DEFAULT_DIRECTION, s));
	}
	public List<Babymodel> getbypage(int pagno,int pagsize)
	{
		Page<Babymodel> p=br.findAll(PageRequest.of(pagno, pagsize));
		return p.getContent();
	}
	public List<Babymodel> getpage(int pagno,int pagsize)
	{
		PageRequest pq=PageRequest.of(pagno, pagsize,Sort.by("lastname").descending());
		Page<Babymodel> pm=br.findAll(pq);
		return pm.getContent();
	}

}
