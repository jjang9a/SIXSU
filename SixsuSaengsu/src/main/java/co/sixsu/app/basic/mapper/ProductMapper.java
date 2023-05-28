package co.sixsu.app.basic.mapper;

import java.util.List;

import co.sixsu.app.basic.domain.ReceiveVO;

public interface ProductMapper {

	public List<ReceiveVO> readySpList(); // 반제품 입고대기목록

	public ReceiveVO procSpLotInfo(ReceiveVO vo); // 반제품 LOT정보 프로시저 호출
	public int insertSpRec(ReceiveVO vo); // 반제품 입고내역 등록
	public int insertSpLot(ReceiveVO vo); // 반제품 LOT 새로 부여
	public int updateSpLot(ReceiveVO vo); // 반제품 LOT 업데이트
	public String getSpLotId(String spId); // 반제품 LOT번호 생성

	
}
