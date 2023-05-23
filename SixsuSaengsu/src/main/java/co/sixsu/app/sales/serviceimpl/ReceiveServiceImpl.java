package co.sixsu.app.sales.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.sales.mapper.ReceiveMapper;
import co.sixsu.app.sales.service.ReceiveService;
@Service("receiveService")
public class ReceiveServiceImpl implements ReceiveService {
@Autowired ReceiveMapper mapper;
	
}
