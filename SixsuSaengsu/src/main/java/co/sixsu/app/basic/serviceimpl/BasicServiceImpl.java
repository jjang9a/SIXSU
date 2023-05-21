package co.sixsu.app.basic.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.basic.domain.CodeVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.basic.domain.SearchDTO;
import co.sixsu.app.basic.mapper.BasicMapper;
import co.sixsu.app.basic.service.BasicService;

@Service("BasicService")
public class BasicServiceImpl implements BasicService{
	
	@Autowired BasicMapper mapper;
	
	// 사원 관리
	@Override // 전체 사원목록 조회
	public List<EmpVO> getEmpList() {
		return mapper.empList();
	}
	
	@Override // 비밀번호 업데이트
	public boolean updatePw(EmpVO emp) {
		System.out.println("service : " + emp);
		return 	mapper.updatePw(emp) == 1;
	}
	@Override // 사원 등록
	public EmpVO addEmp(EmpVO emp) {
		emp.setEmpStat("재직");
		String bir = emp.getEmpBirth();
		String pw = bir.substring(2, 4) + bir.substring(5,7) + bir.substring(8);
		emp.setEmpPw(pw);
		mapper.addEmp(emp);
		return emp;
	}

	@Override // 사원정보 업데이트
	public boolean updateEmp(EmpVO emp) {
		return mapper.updateEmp(emp) == 1;
	}

	
	
	// 공통코드 관리
	@Override // 그룹코드 전체목록
	public List<CodeVO> groupList() {
		return mapper.groupList();
	}

	@Override // 선택된 공통코드 목록
	public List<CodeVO> commList(SearchDTO dto) {
		return mapper.commList(dto);
	}

	@Override // 공통코드 추가
	public boolean addCode(List<CodeVO> list) {
		int count = 0; // insert가 발생한 횟수
		for(int i=0; i<list.size(); i++) {
			// 공통코드가 빈칸으로 들어 가 있는 열은 extra로 취급해 등록하지 않음
			if(list.get(i).getComId() == null || list.get(i).getComId().equals("")){
				continue;
			}else {
				count += mapper.addCode(list.get(i));				
			}
		}
		return count >= 1;
	}

	@Override // 공통코드 수정
	public boolean updateCode(List<CodeVO> list) {
		int count = 0; // update가 발생한 횟수
		for(int i=0; i<list.size(); i++) {
			// 공통코드가 빈칸으로 들어 가 있는 열은 실수라고 생각하고 수정하지 않음
			if(list.get(i).getComId() == null || list.get(i).getComId().equals("")){
				continue;
			}else {
				count += mapper.updateCode(list.get(i));				
			}
		}
		return count >= 1;
	}

	// 완제품 관리
	
	@Override // 완제품 목록
	public List<ProductVO> cpList() {
		return mapper.cpList();
	}

	@Override // 완제품 등록
	public boolean addCp(ProductVO prod) {
		return mapper.addCp(prod) == 1;
	}

	@Override
	public boolean updateCp(ProductVO prod) {
		return mapper.updateCp(prod) == 1;
	}
	
	
	
}
