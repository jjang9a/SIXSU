package co.sixsu.app.basic.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.sixsu.app.basic.domain.BomVO;
import co.sixsu.app.basic.domain.BusVO;
import co.sixsu.app.basic.domain.CodeVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.domain.FlowVO;
import co.sixsu.app.basic.domain.MaterialVO;
import co.sixsu.app.basic.domain.ProcessVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.basic.domain.SearchDTO;
import co.sixsu.app.basic.mapper.BasicMapper;
import co.sixsu.app.basic.service.BasicService;
import co.sixsu.app.sales.domain.GridDataVO;

@Service("BasicService")
public class BasicServiceImpl implements BasicService, UserDetailsService {

	@Autowired
	BasicMapper mapper;

	// 사원 관리
	@Override // 전체 사원목록 조회
	public List<EmpVO> getEmpList() {
		return mapper.empList();
	}

	@Override // 비밀번호 업데이트
	public boolean updatePw(EmpVO emp) {
		BCryptPasswordEncoder bcrype = new BCryptPasswordEncoder(10);
		String password = bcrype.encode(emp.getEmpPw()); // 스프링 시큐리티 비크립트 암호화
		emp.setEmpPw(password);
		return mapper.updatePw(emp) == 1;
	}

	@Override // 사원 등록
	public EmpVO addEmp(EmpVO emp) {
		emp.setEmpStat("재직");
		String bir = emp.getEmpBirth();
		String pw = bir.substring(2, 4) + bir.substring(5, 7) + bir.substring(8);
		
		BCryptPasswordEncoder bcrype = new BCryptPasswordEncoder(10);
		String password = bcrype.encode(pw); // 스프링 시큐리티 비크립트 암호화
		
		emp.setEmpPw(password);
		mapper.addEmp(emp);
		return emp;
	}

	@Override // 사원정보 업데이트
	public boolean updateEmp(EmpVO emp) {
		return mapper.updateEmp(emp) == 1;
	}

	@Override // 사원 검색
	public List<EmpVO> searchEmp(SearchDTO dto) {
		return mapper.searchEmp(dto);
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

	@Override // 공통코드 수정
	public boolean updateCode(GridDataVO<CodeVO> data) {
		int count = 0; // update가 발생한 횟수

		List<CodeVO> list = data.getUpdatedRows();
		for (int i = 0; i < list.size(); i++) {
			// 공통코드가 빈칸으로 들어 가 있는 열은 실수라고 생각하고 수정하지 않음
			if (list.get(i).getComId() == null || list.get(i).getComId().equals("")) {
				continue;
			} else {
				count += mapper.updateCode(list.get(i));
			}
		}

		list = data.getCreatedRows();
		for (int i = 0; i < list.size(); i++) {
			// 공통코드가 빈칸으로 들어 가 있는 열은 extra로 취급해 등록하지 않음
			if (list.get(i).getComId() == null || list.get(i).getComId().equals("")) {
				continue;
			} else {
				count += mapper.addCode(list.get(i));
			}
		}
		return count >= 1;
	}

	@Override
	public boolean addGroup(CodeVO code) {
		return mapper.addGroup(code) == 1;
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

	@Override // 완제품 수정
	public boolean updateCp(ProductVO prod) {
		return mapper.updateCp(prod) == 1;
	}

	@Override // 완제품 검색
	public List<ProductVO> searchCp(SearchDTO dto) {
		return mapper.searchCp(dto);
	}

	// 반제품 관리

	@Override // 반제품 목록
	public List<ProductVO> spList() {
		return mapper.spList();
	}

	@Override // 반제품 등록
	public boolean addSp(ProductVO prod) {
		return mapper.addSp(prod) == 1;
	}

	@Override // 반제품 수정
	public boolean updateSp(ProductVO prod) {
		return mapper.updateSp(prod) == 1;
	}

	@Override // 반제품 검색
	public List<ProductVO> searchSp(SearchDTO dto) {
		return mapper.searchSp(dto);
	}

	// 자재 관리

	@Override // 자재 목록
	public List<MaterialVO> matList() {
		return mapper.matList();
	}

	@Override // 자재 등록
	public boolean addMat(MaterialVO mat) {
		return mapper.addMat(mat) == 1;
	}

	@Override // 자재 수정
	public boolean updateMat(MaterialVO mat) {
		return mapper.updateMat(mat) == 1;
	}

	@Override // 자재 검색
	public List<MaterialVO> searchMat(SearchDTO dto) {
		return mapper.searchMat(dto);
	}

	// 거래처 관리

	@Override // 사업자번호 중복 조회
	public boolean checkBusNum(String num) {
		boolean result = false;
		if (mapper.checkBusNum(num) == 0) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	@Override // 거래처 목록
	public List<BusVO> busList() {
		return mapper.busList();
	}

	@Override // 거래처 등록
	public boolean addBus(BusVO bus) {
		if (bus.getBusAddrDet() != null || !bus.getBusAddrDet().equals("")) {
			bus.setBusAddr(bus.getBusAddr() + " " + bus.getBusAddrDet());
		}
		return mapper.addBus(bus) == 1;
	}

	@Override // 거래처 수정
	public boolean updateBus(BusVO bus) {
		return mapper.updateBus(bus) == 1;
	}

	@Override // 거래처 검색
	public List<BusVO> searchBus(SearchDTO dto) {
		return mapper.searchBus(dto);
	}

	// 공정관리

	@Override // 공정 목록
	public List<ProcessVO> procList() {
		return mapper.procList();
	}

	@Override
	public List<CodeVO> getComList(String key) {
		return mapper.getComList(key);
	}

	@Override
	public boolean addProc(ProcessVO mat) {
		return mapper.addProc(mat) == 1;
	}

	@Override
	public boolean updateProc(ProcessVO mat) {
		return mapper.updateProc(mat) == 1;
	}

	@Override
	public List<ProcessVO> searchProc(SearchDTO dto) {
		return mapper.searchProc(dto);
	}

	// BOM 관리

	@Override // 제품별 bomList
	public List<BomVO> bomList(String id) {
		List<BomVO> list = mapper.bomList(id);
		// 제품구분이 반제품이라면 sp_name을 mat_name에 담아줌
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPdType().equals("반제품")) {
				list.get(i).setMatName(list.get(i).getSpName());
			}
		}
		return list;
	}

	@Override // 활성화된 완제품 목록
	public List<ProductVO> activeCpList() {
		return mapper.activeCpList();
	}

	@Override // 활성화된 반제품 목록
	public List<ProductVO> activeSpList() {
		return mapper.activeSpList();
	}

	@Override
	public boolean addBom(List<BomVO> list) {
		int count = 0; // insert가 발생한 횟수
		for (int i = 0; i < list.size(); i++) {
			count += mapper.addBom(list.get(i));
		}
		return count >= 1;
	}

	@Override
	public boolean updateBom(GridDataVO<BomVO> vo) {
		int count = 0; // update가 발생한 횟수
		// insert
		List<BomVO> list = vo.getCreatedRows();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				count += mapper.addBom(list.get(i));
			}
		}
		// update
		list = vo.getUpdatedRows();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				count += mapper.updateBom(list.get(i));
			}
		}
		// delete
		list = vo.getDeletedRows();
		if (list.size() > 0) {
			count += mapper.deleteBom(list);
		}
		return count >= 1;
	}

	@Override // 활성화된 자재 목록
	public List<ProductVO> activeMaterialList() {
		return mapper.activeMatList();
	}

	@Override // 활성화된 공정 목록
	public List<ProcessVO> activeProcList() {
		return mapper.activeProcList();
	}

	@Override
	public boolean deleteBom(List<BomVO> list) {
		return mapper.deleteBom(list) > 0;
	}

	// 공정흐름도

	@Override // 제품별 공정흐름도
	public List<FlowVO> flowList(String id) {
		return mapper.flowList(id);
	}

	@Override // 공정흐름도 등록, 수정 삭제
	public boolean updateFlow(GridDataVO<FlowVO> vo) {
		int count = 0; // update가 발생한 횟수
		// insert
		List<FlowVO> list = vo.getCreatedRows();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				count += mapper.addFlow(list.get(i));
			}
		}
		// update
		list = vo.getUpdatedRows();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				count += mapper.updateFlow(list.get(i));
			}
		}
		// delete
		list = vo.getDeletedRows();
		if (list.size() > 0) {
			count += mapper.deleteFlow(list);
		}
		return count >= 1;
	}

	@Override // 공통코드 사용을 위한 MAP
	public List<Map<String, String>> commGroupList(String code) {
		return mapper.commGroupList(code);
	}

	@Override // 스프링 시큐리티
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 단건조회
		EmpVO vo = mapper.getEmp(username);
		// ID가 없으면 error
		if (vo == null) {
			throw new UsernameNotFoundException("no id");
		}
		vo.setRoleId(mapper.getRole(username));
		// ID가 있다면 VO return
		return vo;
	}

}
