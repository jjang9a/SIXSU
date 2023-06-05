package co.sixsu.app.sales.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.sales.domain.RecVO;
import co.sixsu.app.sales.mapper.ReceiveMapper;
import co.sixsu.app.sales.service.ReceiveService;
@Service("receiveService")
public class ReceiveServiceImpl implements ReceiveService {
@Autowired ReceiveMapper mapper;

@Override
public List<RecVO> completeList() {
	// TODO Auto-generated method stub
	return mapper.completeList();
}

@Override
public List<RecVO> searchReceive(RecVO vo) {
	// TODO Auto-generated method stub
	return mapper.searchReceive(vo);
}
	
}
