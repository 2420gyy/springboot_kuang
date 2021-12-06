package com.lyx.service.impl;

import com.lyx.dao.TUserTitleMapper;
import com.lyx.model.TUserTitle;
import com.lyx.service.UserTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserTitleServiceImpl implements UserTitleService {

    @Autowired
    private TUserTitleMapper userTitleMapper;

    @Override
    public List<TUserTitle> findAllTUserTitle() {
        return userTitleMapper.selectByExample(null);
    }
}
