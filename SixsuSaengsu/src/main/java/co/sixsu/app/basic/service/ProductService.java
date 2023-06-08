package co.sixsu.app.basic.service;

import java.util.List;

import co.sixsu.app.basic.domain.ReceiveVO;
import co.sixsu.app.basic.domain.SalesVO;
import co.sixsu.app.quality.domain.QilVO;
import co.sixsu.app.work.domain.PfmcVO;

public interface ProductService {

	// 반제품 입고 관리
	List<ReceiveVO> readySpList(); // 반제품 입고대기 목록
	List<ReceiveVO> spRecList(); // 반제품 입고목록
	List<ReceiveVO> spRec(List<ReceiveVO> list); // 반제품 입고
	
	// 반제품 입고 조회
	List<ReceiveVO> spRecSearch(ReceiveVO vo);
	
	// 완제품 입고 관리
	List<ReceiveVO> readyCpList(); // 반제품 입고대기 목록
	List<ReceiveVO> cpRecList(); // 반제품 입고목록
	List<ReceiveVO> cpRec(List<ReceiveVO> list); // 완제품 입고
	
	// 공정실적 조회
	List<PfmcVO> performanceList(); // 공정실적 리스트
	List<PfmcVO> searchPerformance(PfmcVO vo); // 공정실적 검색
	
	// 품질검사 항목관리
	List<QilVO> getInspList(); // 품질검사 항목 목록
	boolean addInsp(QilVO vo); // 검사항목 추가
	boolean updateInsp(QilVO vo); // 검사항목 수정
	
	// 판매실적 조회
	String getSalesInfo(SalesVO vo); // 상품별 판매실적 조회
	String getSalesCount(SalesVO vo); // 상품별 판매 개수 실적 조회
	String getMonthlySales(SalesVO vo); // 월별 매출액 추이
}
