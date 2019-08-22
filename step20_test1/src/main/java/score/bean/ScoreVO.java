package score.bean;

public class ScoreVO {
	  String studNo;
	  String name;
	  int kor;
	  int eng;
	  int mat;
	  int tot;
	  double avg;
	  String logtime;
	  
	@Override
	public String toString() {
		return "[학번 = " + studNo + ", 이름 =" + name + ", 국어 =" + kor + ", 영어 =" + eng + ", 수학 =" + mat
				+ ", 총점 =" + tot + ", 평균 =" + avg + ", 날짜=" + logtime + "]";
	}
	public String getStudNo() {
		return studNo;
	}
	public void setStudNo(String studNo) {
		this.studNo = studNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	  
	  
}
