package co.sixsu.app.basic.service;

import java.util.List;

import co.sixsu.app.basic.domain.ReceiveVO;

public interface ProductService {

	List<ReceiveVO> readySpList(); // 반제품 입고대기 목록
	List<ReceiveVO> spRec(List<ReceiveVO> list); // 반제품 입고
	
}
