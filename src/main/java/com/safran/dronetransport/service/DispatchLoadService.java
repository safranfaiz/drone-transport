package com.safran.dronetransport.service;

import com.safran.dronetransport.entity.DispatchLoad;

import java.util.List;

public interface DispatchLoadService {

    DispatchLoad createDispatch();

    List<DispatchLoad> findAll();
}
