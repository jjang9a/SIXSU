package co.sixsu.app.mes.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.mes.mapper.CommonMapper;

@Service("commonService")
public class CommonServiceImpl {
	
	@Autowired CommonMapper commonMapper;
	
	
}
