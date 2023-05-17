package co.sixsu.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.domain.equipment.EquConVO;
import co.sixsu.app.mapper.EquMapper;
import co.sixsu.app.service.EquService;

@Service("EquService")
public class EquServiceImpl implements EquService{

	@Autowired EquMapper mapper;
	
	@Override
	public List<EquConVO> equConList() {
		System.out.println("hi");
		return mapper.equConList();
	}

}
