package com.mplus.MPortal.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mplus.MPortal.model.Menu;
import com.mplus.MPortal.service.MenuService;
import com.mplus.core.service.BaseServiceImpl;

@Service
@Transactional
public class MenuServiceImpl extends BaseServiceImpl<Menu, String> implements MenuService {

}
