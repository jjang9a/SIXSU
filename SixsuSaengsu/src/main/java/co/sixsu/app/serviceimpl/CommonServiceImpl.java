package co.sixsu.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.mapper.CommonMapper;

@Service("commonService")
public class CommonServiceImpl {
	
	@Autowired CommonMapper commonMapper;
	
	
}
