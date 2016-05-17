package com.asm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.asm.dao.IAssetRepairDao;
import com.asm.domain.AssetRepair;

@Repository("iAssetRepairDao")

public class AssetRepairDaoImpl extends CommonDaoImpl<AssetRepair> implements IAssetRepairDao {

}
