package com.asm.service;

import java.util.Date;
import java.util.List;

import com.asm.domain.AssetSort;
import com.asm.domain.Scrap;
import com.asm.domain.User;

public interface ScrapService {

	public abstract List<Scrap> listScrap(String assettName,String purchaseId);

	public abstract void saveScrap(Scrap scrap);

	public abstract boolean remove(String scrapId);

	public abstract Scrap findScrap(String scrapId);

	public abstract boolean updateScrap(Scrap scrap);
	

}