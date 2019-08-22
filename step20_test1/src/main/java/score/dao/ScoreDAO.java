package score.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import score.bean.ScoreVO;

@Repository
public class ScoreDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;	
	//SQL명령어들: Mybatis 사용
	
	public int insertScore(ScoreVO vo) {
		                                  //score-mapping에 있는 name-space
		return sqlSessionTemplate.insert("mybatis.scoreMapper.insertScore", vo);
	}
	
    public List<ScoreVO> viewList(int startNum, int endNum){
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	map.put("startNum", startNum);
    	map.put("endNum", endNum);
    	return sqlSessionTemplate.selectList("mybatis.scoreMapper.viewList", map);
    }
    
    public int getTotalA() {
		
		return sqlSessionTemplate.selectOne("mybatis.scoreMapper.getTotalA");
	}
     
    public ScoreVO viewScore(String studNo) {
		
		return sqlSessionTemplate.selectOne("mybatis.scoreMapper.viewScore", studNo);
	}
    
    public int scoreDelete(String studNo) {
		
		return sqlSessionTemplate.delete("mybatis.scoreMapper.scoreDelete", studNo);
	}
    public int modifyScore(ScoreVO vo) {    	
		return sqlSessionTemplate.update("mybatis.scoreMapper.modifyScore", vo);
    }
}
