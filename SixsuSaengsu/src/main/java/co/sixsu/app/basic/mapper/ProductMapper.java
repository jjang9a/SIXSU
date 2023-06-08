package co.sixsu.app.basic.mapper;

import java.util.List;

import co.sixsu.app.basic.domain.ReceiveVO;
import co.sixsu.app.basic.domain.SalesVO;
import co.sixsu.app.quality.domain.QilVO;
import co.sixsu.app.work.domain.PfmcVO;

public interface ProductMapper {

	// 반제품 입고관리
	public List<ReceiveVO> readySpList(); // 반제품 입고대기목록
	public List<ReceiveVO> spRecList(); // 반제품 입고목록

	public ReceiveVO procSpLotInfo(ReceiveVO vo); // 반제품 LOT정보 프로시저 호출
	public int insertSpRec(ReceiveVO vo); // 반제품 입고내역 등록
	public int insertSpLot(ReceiveVO vo); // 반제품 LOT 새로 부여
	public int updateSpLot(ReceiveVO vo); // 반제품 LOT 업데이트
	public String getSpLotId(String spId); // 반제품 LOT번호 생성
	
	// 반제품 입고 조회
	public List<ReceiveVO> spRecSearch(ReceiveVO vo); // 반제품 입고 검색

	// 완제품 입고관리
	public List<ReceiveVO> readyCpList(); // 완제품 입고대기목록
	public List<ReceiveVO> cpRecList(); // 완제품 입고목록
	
	public ReceiveVO procCpLotInfo(ReceiveVO vo); // 완제품 LOT정보 프로시저 호출
	public int insertCpRec(ReceiveVO vo); // 완제품 입고내역 등록
	public int insertCpLot(ReceiveVO vo); // 완제품 LOT 새로 부여
	public int updateCpLot(ReceiveVO vo); // 완제품 LOT 업데이트
	public String getCpLotId(String cpId); // 완제품 LOT번호 생성
	
	// 공정실적 조회
	public List<PfmcVO> performanceList(); // 공정실적 리스트
	public List<PfmcVO> searchPerformance(PfmcVO vo); // 공정실적 검색
	
	// 검사항목 관리
	public List<QilVO> getInspList(); // 검사항목 리스트
	public int addInsp(QilVO vo); // 검사항목 추가
	public int updateInsp(QilVO vo); // 검사항목 수정
	
	// 판매실적 조회
	public List<SalesVO> getSalesInfo(SalesVO vo); // 상품별 판매 금액 실적 조회
	public List<SalesVO> getSalesCount(SalesVO vo); // 상품별 판매 개수 실적 조회
	public List<SalesVO> getMonthlySales(SalesVO vo); // 월별 매출액 추이
	
}
