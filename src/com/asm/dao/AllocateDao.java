package com.asm.dao;

import java.util.List;

import com.asm.domain.Allocate;

public interface AllocateDao {
	public abstract List<Allocate> findList();
	public abstract void add(Allocate allocate);
}
