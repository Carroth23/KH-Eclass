package kh.spring.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dao.BoardDAO;
import kh.spring.dao.FilesDAO;
import kh.spring.dto.BoardDTO;
import kh.spring.dto.FilesDTO;
import kh.spring.dto.ReplyDTO;

@Service
public class BoardService {

//	@Autowired 세션은 웹티어에 해당한다. 여기로 오면 안됨
//	private HttpSession session;

	@Autowired
	public BoardDAO bdao;
	
	@Autowired
	private FilesDAO fdao;

	public List<BoardDTO> selectAll() {
		return bdao.selectAll();
	}

	public int boardInsert(BoardDTO dto) {
		return bdao.boardInsert(dto);
	}

	public BoardDTO selectSeq(int seq) {
		return bdao.selectSeq(seq);
	}

	public List<ReplyDTO> selectReply(int seq) {
		return bdao.selectReply(seq);
	}

	public int deletePost(int seq) {
		return bdao.deletePost(seq);
	}

	public int modify(BoardDTO dto) {
		return bdao.modify(dto);
	}

	public int replyInsert(ReplyDTO dto) {
		return bdao.replyInsert(dto);
	}

	public void writeProc(BoardDTO dto, String realPath, MultipartFile[] file) throws Exception {
		bdao.boardInsert(dto); // 게시판에 작석된 내용 을 DB에 저장하는 부문
		// 파일의 갯수만큼
		for (MultipartFile mf : file) {
			if (!mf.isEmpty()) { // 업로드된 파일 중 첫 번째 파일이 비어있지 않다면 파일업로드 실행.(첨부안하고 완료해도 텅빈파일이 올라가기때문)
				File realPathFile = new File(realPath); // 주어진 문자열 경로를 갖는 File 객체를 생성
				if (!realPathFile.exists()) {
					realPathFile.mkdir();
				} // upload 폴더가 존재하지않으면 만들어라
				String oriName = mf.getOriginalFilename(); // 사용자가 업로드 한 파일의 원본 이름
				// UUID.randomUUID(); // 절대 겹치지않는 무작위의 문자열을 만들어줌
				String sysName = UUID.randomUUID() + "_" + oriName; // 서버쪽에 저장할 파일 이름
				// 서버에 업로드되어 메모리에 적재된 파일의 내용을 어디에 저장할지 결정하는 부분
				mf.transferTo(new File(realPath + "/" + sysName)); // 첨부된 파일 폴더에 업로드
				fdao.insert(new FilesDTO(0, oriName, sysName, dto.getSeq())); // 첨부된 파일 정보를 DB에 저장하는 부분
			}
		}
	}

}
