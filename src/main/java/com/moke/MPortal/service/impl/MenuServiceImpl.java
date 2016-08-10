package com.moke.MPortal.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moke.MPortal.model.Menu;
import com.moke.MPortal.service.MenuService;
import com.moke.core.service.impl.BaseServiceImpl;

@Service
@Transactional
public class MenuServiceImpl extends BaseServiceImpl<Menu, String> implements MenuService {

}
