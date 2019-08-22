package score.controller;

import java.util.List;

import score.bean.ScoreVO;

public interface ScoreService {
     int scoreWrite(ScoreVO scoreVO);
     int scoreModify(ScoreVO scoreVO);
     int boardDelete(String studNo);
     ScoreVO scoreView(String studNO);
     List<ScoreVO> scoreList(int startNum, int endNum);
     int updateHit(String studNo);
     int getTotalA();
}
