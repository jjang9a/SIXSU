package co.sixsu.app.basic.service;

import java.util.List;

import co.sixsu.app.basic.domain.ReceiveVO;

public interface ProductService {

	// 반제품 입고 관리
	List<ReceiveVO> readySpList(); // 반제품 입고대기 목록
	List<ReceiveVO> spRecList(); // 반제품 입고목록
	List<ReceiveVO> spRec(List<ReceiveVO> list); // 반제품 입고
	
	// 완제품 입고 관리
	List<ReceiveVO> readyCpList(); // 반제품 입고대기 목록
	List<ReceiveVO> cpRecList(); // 반제품 입고목록
	List<ReceiveVO> cpRec(List<ReceiveVO> list); // 완제품 입고
	
}
