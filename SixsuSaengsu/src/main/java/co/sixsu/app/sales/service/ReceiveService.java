package co.sixsu.app.sales.service;

import java.util.List;

import co.sixsu.app.sales.domain.InvVO;
import co.sixsu.app.sales.domain.RecVO;

public interface ReceiveService {
	List<RecVO> completeList(); //모달창 입고전 생산완료 조회
	List<RecVO> searchReceive(RecVO vo);

}
