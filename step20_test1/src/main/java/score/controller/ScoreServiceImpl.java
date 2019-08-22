package score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import score.bean.ScoreVO;
import score.dao.ScoreDAO;

@Service
public class ScoreServiceImpl implements ScoreService {
	//ScoreDAO쪽에서 빈객체 설정을 이미 해놨기 때문에, ServiceImpl에서 Autowired로 자동주입만 해줌 
	@Autowired
	private ScoreDAO scoreDAO; 
	
	@Override
	public int scoreWrite(ScoreVO scoreVO) {
		
		return scoreDAO.insertScore(scoreVO);
	}

	@Override
	public int scoreModify(ScoreVO scoreVO) {
	
		return scoreDAO.modifyScore(scoreVO);
	}

	@Override
	public int boardDelete(String studNo) {
		
		return scoreDAO.scoreDelete(studNo);
	}

	@Override
	public ScoreVO scoreView(String studNO) {
	
		return scoreDAO.viewScore(studNO);
	}

	@Override
	public List<ScoreVO> scoreList(int startNum, int endNum) {
		
		return scoreDAO.viewList(startNum, endNum);
	}

	@Override
	public int updateHit(String studNo) {
		
		return 0;
	}

	@Override
	public int getTotalA() {
		
		return scoreDAO.getTotalA();
	}
    
}
