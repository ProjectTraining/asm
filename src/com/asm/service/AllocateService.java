package com.asm.service;

import java.util.List;

import com.asm.domain.Allocate;

public interface AllocateService {
	public abstract List<Allocate> findList();
	public abstract void add (Allocate allocate);
}
